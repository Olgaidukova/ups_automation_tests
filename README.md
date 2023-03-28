<h1 >Проект автоматизации UI для сайта <a href="https://www.web.com/ru/ru/Home.page">UPS.com</a></h1>

## :pushpin: Содержание:

* <a href="#tools">Технологии и инструменты</a>
* <a href="#cases">Реализованные проверки</a>
* <a href="#console">Запуск тестов из терминала</a>
* <a href="#jenkins">Запуск тестов в Jenkins</a>
* <a href="#allure">Отчеты в Allure</a>
* <a href="#testops">Интеграция с Allure TestOps</a>
* <a href="#testops">Интеграция с Jira</a>
* <a href="#telegram">Уведомления в Telegram с использованием бота</a>
* <a href="#video">Пример прогона теста в Selenoid</a>

<a id="tools"></a>
## :computer: Технологии и инструменты

<div align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="images/logo/Intelij_IDEA.svg" width="50"/></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="images/logo/GitHub.svg" width="50"/></a>  
<a href="https://www.java.com/"><img alt="Java" height="50" src="images/logo/Java.svg" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="images/logo/Gradle.svg" width="50"/></a>  
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="images/logo/JUnit5.svg" width="50"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="images/logo/Selenide.svg" width="50"/></a>
<a href="https://aerokube.com/selenoid/"><img alt="Selenoid" height="50" src="images/logo/Selenoid.svg" width="50"/></a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="images/logo/Jenkins.svg" width="50"/></a>
<a href="https://github.com/allure-framework/"><img alt="Allure Report" height="50" src="images/logo/Allure_Report.svg" width="50"/></a>
<a href="https://qameta.io/"><img alt="Allure TestOps" height="50" src="images/logo/AllureTestOps.png" width="120"/></a>
<a href="https://www.atlassian.com/software/jira"><img alt="Jira" height="50" src="images/logo/Jira.png" width="50"/></a>  
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="images/logo/Telegram.svg" width="50"/></a>
</div>

Автотесты написаны на <code>Java</code> с использованием <code>JUnit 5</code> и <code>Gradle</code>.
Для UI-тестов использован фреймворк [Selenide](https://selenide.org/).
Запуск тестов можно осуществлять локально или с помощью [Selenoid](https://aerokube.com/selenoid/).
Также реализована сборка в <code>Jenkins</code> с формированием Allure-отчета и отправкой уведомления с результатами в <code>Telegram</code> после завершения прогона.

Allure-отчет включает в себя:
* шаги выполнения тестов;
* скриншот страницы в браузере в момент окончания автотеста;
* Page source;
* логи браузерной консоли;
* видео выполнения автотеста.

<a id="cases"></a>
## Реализованные проверки

### Автоматизированные проверки
✓ Проверка авторизации с некорректным логин/пароль

✓ Проверка расчета сроков и стоимости доставки

✓ Проверка возможности восстановления пароля

✓ Проверка заполнения формы регистрации

✓ Проверка отслеживания трек-номера

✓ Проверка доступных услуг

### Ручные проверки
✓ Проверка авторизации с логин/пароль существующего пользователя

✓ Проверка восстановления имени пользователя


<a id="console"></a>
## :running_woman: Запуск тестов из терминала
### Локальный запуск тестов

```
gradle clean test 
```

### Удаленный запуск тестов

```
clean test \
  -Dbrowser=${BROWSER} \
  -DbrowserVersion=${BROWSER_VERSION} \
  -DbrowserSize=${BROWSER_SIZE} \
  -Dremote=${REMOTE}
```

> `${BROWSER}` - наименование браузера (_по умолчанию - <code>chrome</code>_).
>
> `${BROWSER_VERSION}` - номер версии браузера (_по умолчанию - <code>100.0</code>_).
>
> `${BROWSER_SIZE}` - размер окна браузера (_по умолчанию - <code>1920x1080</code>_).
>
> `${REMOTE}` - адрес удаленного сервера, на котором будут запускаться тесты.

<a id="jenkins"></a>
## <img width="4%" style="vertical-align:middle" title="Jenkins" src="images/logo/Jenkins.svg"> Запуск тестов в <a target="_blank" href="https://jenkins.autotests.cloud/job/OGaidukova-ups-autotests/"> Jenkins </a>

> Сборка с параметрами позволяет перед запуском выбрать параметры для сборки.

<p align="center">
<img src="images/screenshots/jenkins.png"/></a>
</p>

<a id="allure"></a>
## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Allure_Report.svg"> Отчеты в <a target="_blank" href="https://jenkins.autotests.cloud/job/OGaidukova-ups-autotests/9/allure/"> Allure report </a>

### Основное окно

<p align="center">
<img src="images/screenshots/AllureOverview.png">
</p>

### Тесты

<p align="center">
<img src="images/screenshots/AllureBehaviors.png">
</p>

### Графики

<p align="center">
<img src="images/screenshots/AllureGraphs.png">
</p>

<a id="testops"></a>
## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/AllureTestOps.png"> Интеграция с <a target="_blank" href="https://allure.autotests.cloud/project/1889/test-cases?treeId=3631"> Allure TestOps </a>

### Доска
<p align="center">
<img src="images/screenshots/AllureTestOpsDashboard.png">
</p>

### Тест-кейсы
<p align="center">
<img src="images/screenshots/AllureTestCases.png">
</p>

### Пример мануального тест-кейса
<p align="center">
<img src="images/screenshots/AllureTestOpsManualTest.png">
</p>


<a id="jira"></a>
## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Jira.png"> Интеграция с <a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-540"> Jira </a>
<p align="center">
<img src="images/screenshots/Jira.png">
</p>

<a id="telegram"></a>
## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Telegram.svg"> Уведомления в Telegram с использованием бота

<p>
<img src="images/screenshots/TelegramBot.png">
</p>

<a id="video"></a>
## <img width="4%" style="vertical-align:middle" title="Allure Report" src="images/logo/Selenoid.svg"> Пример прогона теста в Selenoid

> К каждому тесту в отчете прилагается видео
<p align="center">
  <img src="images/video/video.gif">
</p>