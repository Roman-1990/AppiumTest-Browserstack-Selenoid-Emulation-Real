___

### Для разработки автотестов использовались технологии и инструменты:

| IntelliJ IDEA | Java | Gradle | Junit5 | Selenide | Appium |

| <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/src/test/resources/img/logo/Intelij_IDEA.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/src/test/resources/img/logo/Java.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/src/test/resources/img/logo/Gradle.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/src/test/resources/img/logo/JUnit5.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/src/test/resources/img/logo/Selenide.png" width="40" height="40"> |

| GitHub | Browserstack | Jenkins | Selenoid | Allure Report | Allure TestOps | Telegram |

| <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/src/test/resources/img/logo/Github.png" width="40" height="40"> || <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/src/test/resources/img/logo/browserstack.jpeg" width="40" height="40"> | <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/src/test/resources/img/logo/Jenkins.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/src/test/resources/img/logo/Selenoid.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/src/test/resources/img/logo/Allure_Report.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/src/test/resources/img/logo/AllureTestOps.png" width="40" height="40"> | <img src="https://github.com/Roman-1990/AppiumTest-Browserstack-Selenoid-Emulation-Real/blob/master/src/test/resources/img/logo/Telegram.png" width="40" height="40"> |

___


### Launch tests in the terminal:

Run test browserstack:
* gradle clean browserstack -DdeviceHost=browserstack 

Run test emulator:
* gradle clean emulator -DdeviceHost=emulator

Run test selenide: 
* gradle clean selenoid -DdeviceHost=selenoid