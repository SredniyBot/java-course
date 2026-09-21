# Структура папок и соглашения

```text
java-games/
  pom.xml                         версии, плагины, явный reactor
  mvnw / mvnw.cmd / .mvn/         воспроизводимый Maven Wrapper
  games/
    star-courier/
      pom.xml / README.md
      src/main/java/edu/course/games/starcourier/
        domain/CourierRules.java
        ui/StarCourierGame.java
        ui/StarCourierRenderer.java
      src/test/java/edu/course/games/starcourier/domain/
        CourierRulesTest.java
        CourierRulesBoundaryTest.java
    ... ещё 24 предметных модуля
  platform/desktop/               Swing-оболочка, ввод, жизненный цикл
  app/                            Launcher и общие integration/architecture tests
  testing/fixtures/               только фабрики независимых тестовых данных
  quality/coverage/               aggregate report, без production логики
  docs/adr/                       почему выбраны эти решения
```

Каталоги модулей — kebab-case; Java packages — lowercase без дефисов; типы — PascalCase; методы/поля — lowerCamelCase; константы — UPPER_SNAKE_CASE. Номер занятия живёт в catalog/roadmap, поэтому перестановка занятий не требует переименования пакетов. `*Rules` обозначает маленькую группу правил; `*Codec`/`*Cipher` выбраны там, где точнее отражают назначение. Не используем общие Utils/Manager/Helper как место для несвязанных операций.

В каждом модуле README рядом с pom, production и тесты в стандартных Maven roots. Доменные тесты имеют тот же package, что и объект проверки. UI-интеграционные тесты всех игр находятся в app, потому что только composition root знает весь состав. Приватные преподавательские тесты отделены физически и не копируются в публичный source root.

Игры не зависят друг от друга. `desktop-platform` — production dependency игровых UI. `test-fixtures` — только test dependency и только в использующих его модулях. Никакого shared-domain ради преждевременного объединения матриц, позиций и направлений разных игр.

## Карта исходных имён

| Исходная папка | Новый модуль | Класс правил |
|---|---|---|
| game01 | [games/star-courier](../games/star-courier/README.md) | `CourierRules` |
| game02 | [games/moon-lander](../games/moon-lander/README.md) | `LanderPhysics` |
| game03 | [games/cloud-jumper](../games/cloud-jumper/README.md) | `PlatformRules` |
| game04 | [games/portal-pong](../games/portal-pong/README.md) | `PaddlePhysics` |
| game05 | [games/brick-garden](../games/brick-garden/README.md) | `BrickRules` |
| game06 | [games/courier-snake](../games/courier-snake/README.md) | `SnakeRules` |
| game07 | [games/lunar-tetris](../games/lunar-tetris/README.md) | `TetrisRules` |
| game08 | [games/mars-mines](../games/mars-mines/README.md) | `MinefieldRules` |
| game09 | [games/memory-cats](../games/memory-cats/README.md) | `MatchingRules` |
| game10 | [games/word-rain](../games/word-rain/README.md) | `WordRules` |
| game11 | [games/balloon-rescue](../games/balloon-rescue/README.md) | `WordMask` |
| game12 | [games/word-maze](../games/word-maze/README.md) | `WordPathRules` |
| game13 | [games/pixel-symmetry](../games/pixel-symmetry/README.md) | `SymmetryRules` |
| game14 | [games/color-flood](../games/color-flood/README.md) | `FloodRules` |
| game15 | [games/lights-out](../games/lights-out/README.md) | `LightRules` |
| game16 | [games/cats-256](../games/cats-256/README.md) | `TileRules` |
| game17 | [games/moon-sokoban](../games/moon-sokoban/README.md) | `WarehouseRules` |
| game18 | [games/laser-mail](../games/laser-mail/README.md) | `BeamRules` |
| game19 | [games/time-canvas](../games/time-canvas/README.md) | `CanvasRules` |
| game20 | [games/space-kitchen](../games/space-kitchen/README.md) | `RecipeRules` |
| game21 | [games/unicode-safari](../games/unicode-safari/README.md) | `UnicodeText` |
| game22 | [games/utf8-radio](../games/utf8-radio/README.md) | `Utf8Codec` |
| game23 | [games/captain-cipher](../games/captain-cipher/README.md) | `CaesarCipher` |
| game24 | [games/ballistic-mail](../games/ballistic-mail/README.md) | `TrajectoryPhysics` |
| game25 | [games/factory-robot](../games/factory-robot/README.md) | `RobotRules` |
