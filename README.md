___

### Для разработки автотестов использовались технологии и инструменты:

| IntelliJ IDEA | Java | Gradle | Junit5 | Selenide | Appium |
|:------:|:----:|:----:|:------:|:------:|:--------:|
| <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/img/logo/Intelij_IDEA.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/img/logo/Java.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/img/logo/Gradle.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/img/logo/JUnit5.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/img/logo/Selenide.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/img/logo/appium.png" width="40" height="40"> |

| GitHub | Browserstack | Jenkins | Selenoid | Allure Report | Allure TestOps | Telegram |
|:------:|:----:|:----:|:------:|:------:|:------:|:--------:|
| <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/img/logo/Github.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/img/logo/browserstack.jpeg" width="40" height="40"> | <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/img/logo/Jenkins.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/img/logo/Selenoid.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/img/logo/Allure_Report.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/img/logo/AllureTestOps.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/img/logo/Telegram.png" width="40" height="40"> |

___

### Для запуска удаленных тестов необходимо заполнить remote.properties или передать значение:

* browser (default chrome)
* browserVersion (default 91.0)
* browserSize (default 1920x1080)
* threads (number of threads)

  <img src = "https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/img/Jenkins.PNG">

## Анализ результатов пройденных тестов через Allure Reports

<img src = "https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/img/Allure.PNG">

### Запуск тестов через терминал:

Run test browserstack:
* gradle clean browserstack -DdeviceHost=browserstack 

Run test emulator:
* gradle clean emulator -DdeviceHost=device

Run test selenide: 
* gradle clean selenoid -DdeviceHost=selenoid

## :robot:Отправка уведомлений о прохождении тестов в <img src = "https://starchenkov.pro/qa-guru/img/skills/Telegram.svg" width = "30">

<img src = "https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/img/Telegram.PNG">

## Визуализация итогов пройденных тестов в Allure TestOps
<img src = "https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/img/AllureTestOps.PNG">

