# Java Automation Testing Framework

Проект для автоматизации тестирования API и UI на Java с использованием Gradle и Cursor.

## 🛠️ Технологии
- **Java 21**
- **Gradle** - сборка проекта
- **JUnit 5** - фреймворк для тестов
- **RestAssured** - тестирование REST API
- **Selenide** - тестирование веб-интерфейсов
- **Allure** - отчёты о тестировании
- **JavaFaker** - генерация тестовых данных
- **Cursor** — создание тестов с помощью AI

## 📁 Структура проекта
src/test/java/
├── api/ # API-тесты (PetStore, JSONPlaceholder)
│ └── tests/ # GET, POST, PUT, DELETE
├── ui/ # UI-тесты (DemoQA, Google)
│ └── tests/ # Кнопки, формы
└── utils/ # Вспомогательные классы (селекторы)

## 📋 Список тестов
**Самостоятельно написанные тесты:**
- API-тесты для https://petstore.swagger.io
- UI-тесты для https://demoqa.com

**Тесты, написанные с помощью Cursor (AI-ассистент):**
- API-тесты для https://jsonplaceholder.typicode.com
- UiTest.java — проверка заголовка Google
- ButtonsTest.java — тестирование кликов на DemoQA

## ⚠️ Важные особенности
 API и UI тесты используют внешние учебные сервисы, которые могут быть недоступны.
### API тесты
- Тестируют публичный Swagger: https://petstore.swagger.io
- Сервис может возвращать 403/502 ошибки

### UI тесты
- Тестируют демо-сайт: https://demoqa.com
- Сайт часто перегружен и медленный
- Установлены таймауты (до 60 секунд)

## Как запустить:
1. Открыть проект в IDEA
2. Найти тест в папке src/test
3. Нажать правой кнопкой → Run