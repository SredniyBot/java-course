# ADR 001: Maven multi-module, Java 25

Статус: принято. Дата: 2026-09-21.

Контекст: 25 независимых учебных игр с отдельными domain/ui packages. Исходник собирался вручную javac, root использовался как source directory. Нужны воспроизводимые зависимости, тесты и понятный импорт в IDE.

Решение: Maven 3.9.11 Wrapper, Java release 25 без preview. Общий parent управляет версиями плагинов и Jupiter BOM. Каждый игровой модуль имеет стандартные src/main/java и src/test/java. Enforcer проверяет JDK [25,26), Maven [3.9.9,4) и dependency convergence. Wrapper distribution проверяется по SHA-256.

Альтернатива: Gradle Kotlin DSL multi-project даёт удобные convention plugins и test fixtures, но для одинаковых Java-модулей здесь добавляет Kotlin DSL и ещё один уровень учебных понятий. Maven XML многословен, зато lifecycle и структура хорошо узнаваемы; общие настройки остаются в одном parent. Две системы сборки одновременно не поддерживаются.

Последствия: локально нужен JDK 25 и сеть при первой загрузке зависимостей. 30 reactor projects, но только 25 игровых модулей; остальные — оболочка, fixtures, launcher и отчёт. Нет скрытых межигровых зависимостей. Обновления версий проходят CI, плавающие LATEST/SNAPSHOT запрещены.

Основания: [Maven Wrapper](https://maven.apache.org/tools/wrapper/), [Compiler 3.14.1](https://maven.apache.org/plugins-archives/maven-compiler-plugin-3.14.1/), [Java 25 specification](https://docs.oracle.com/en/java/javase/25/docs/specs/index.html).
