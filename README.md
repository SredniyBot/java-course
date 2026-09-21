# Java Course — 25 учебных Java-игр

25 исходных игр, 55 методов с TODO. Реализуйте выбранную игру по её README.
Нужен JDK 25; Maven Wrapper загрузит зафиксированный Maven автоматически.
Для Windows используйте `.\mvnw.cmd` вместо `./mvnw`.

```sh
./mvnw -pl :star-courier -am test
```

До реализации эти функциональные тесты ожидаемо красные. Не удаляйте и не отключайте их.
Номер задания и предметное имя модуля — в [ROADMAP](ROADMAP.md).
Структура пакетов — [STRUCTURE](docs/STRUCTURE.md), причины разделения — [ARCHITECTURE](docs/ARCHITECTURE.md).
В каждой игре `domain` содержит правила, `ui` — адаптер и renderer; тесты зеркалят domain.

Чтобы собрать окно, пока другие игры ещё не реализованы:

```sh
./mvnw -DskipTests package
java -jar app/target/java-games-app-1.0.0.jar 1
```

Это упаковка заготовки, не приёмка. Приёмка выполненной игры —
`./mvnw -pl :star-courier -am verify` без skipTests.
Полный `./mvnw clean verify` становится зелёным после выполнения всех игр.
Форматирование: `./mvnw spotless:apply`.

В IDE импортируйте корневой pom.xml, JDK 25; запускайте `edu.course.app.Launcher` с номером игры.
F5 — перезапуск, F6 — пауза. После правки кода пересоберите приложение.
На push/PR CI проверяет компиляцию production/test sources и форматирование заготовок.
Приёмка игры запускается отдельно: Actions → Exercise acceptance → имя модуля.
Зелёная проверка Scaffold build не означает, что задания решены.

01–06: направляющие задания; 07–15: самостоятельный алгоритм;
16–25: DESIGN.md и дополнительный API/design milestone обязательны.
AI разрешён с журналом AI_USAGE.md, независимыми тестами и объяснением на защите.

Приватные преподавательские тесты и решения из этой выдачи удалены.
См. [CONTRIBUTING](CONTRIBUTING.md) и [CODE_STYLE](CODE_STYLE.md).
