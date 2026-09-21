package edu.course.app;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.fields;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.dependencies.SlicesRuleDefinition.slices;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import edu.course.platform.desktop.DesktopGame;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/** Executable dependency rules for the entire reactor, including sibling game artifacts. */
class ArchitectureTest {
  private static JavaClasses productionClasses;

  @BeforeAll
  static void importProductionClasses() {
    productionClasses =
        new ClassFileImporter()
            .withImportOption(new ImportOption.DoNotIncludeTests())
            .importPackages("edu.course");
  }

  @Test
  void domainDoesNotKnowWindowsControllersOrPlatformServices() {
    noClasses()
        .that()
        .resideInAPackage("..domain..")
        .should()
        .dependOnClassesThat()
        .resideInAnyPackage("java.awt..", "javax.swing..", "..ui..", "..platform..", "..app..")
        .check(productionClasses);
  }

  @Test
  void gamesCannotDependOnOtherGames() {
    slices()
        .matching("edu.course.games.(*)..")
        .should()
        .notDependOnEachOther()
        .check(productionClasses);
  }

  @Test
  void platformDoesNotKnowIndividualGamesOrApplication() {
    noClasses()
        .that()
        .resideInAPackage("..platform..")
        .should()
        .dependOnClassesThat()
        .resideInAnyPackage("..games..", "..app..")
        .check(productionClasses);
  }

  @Test
  void renderersAreInternalAndDoNotAccessSessionOrControllerState() {
    classes()
        .that()
        .haveSimpleNameEndingWith("Renderer")
        .should()
        .bePackagePrivate()
        .check(productionClasses);
    noClasses()
        .that()
        .haveSimpleNameEndingWith("Renderer")
        .should()
        .dependOnClassesThat()
        .haveSimpleNameEndingWith("Game")
        .check(productionClasses);
    noClasses()
        .that()
        .haveSimpleNameEndingWith("Renderer")
        .should()
        .dependOnClassesThat()
        .haveSimpleName("GameSession")
        .check(productionClasses);
  }

  @Test
  void mutableFieldsAreEncapsulatedAndNoMutableStaticStateExists() {
    fields().that().areNotFinal().should().bePrivate().check(productionClasses);
    fields().that().areStatic().should().beFinal().check(productionClasses);
  }

  @Test
  void controllersLiveInUiAndThereIsExactlyOneEntryPoint() {
    classes()
        .that()
        .implement(DesktopGame.class)
        .should()
        .resideInAPackage("..ui")
        .check(productionClasses);
    Set<String> entryPoints =
        productionClasses.stream()
            .flatMap(type -> type.getMethods().stream())
            .filter(method -> method.getName().equals("main"))
            .map(method -> method.getOwner().getName())
            .collect(Collectors.toSet());
    assertEquals(Set.of("edu.course.app.Launcher"), entryPoints);
    assertEquals(
        25,
        productionClasses.stream()
            .filter(type -> type.isAssignableTo(DesktopGame.class) && !type.isInterface())
            .count());
  }

  @Test
  void scaffoldingKnowsNeitherDomainNorUi() {
    noClasses()
        .that()
        .resideInAPackage("edu.course.learning..")
        .should()
        .dependOnClassesThat()
        .resideInAnyPackage("..games..", "..platform..", "..app..")
        .check(productionClasses);
  }
}
