# Репозиторий к видео про `finally` в Kotlin/Java

Репозиторий использовался в видео в рамках
цикла об обработке ошибок.

Сделано по следам [этого опросника](https://forms.gle/Yp2Qz9KBBV9pwm1B8)

И для вот этого 
<a href="https://www.youtube.com/watch?v=Qa56w3uB2L4" target="_blank"><img src="https://i9.ytimg.com/vi/Qa56w3uB2L4/mqdefault.jpg?v=639059d0&sqp=CJSzwZwG&rs=AOn4CLBvJ1se2ebHt-7utsgrROgPbAmp3w" alt="вступление" width="96" height="" border="64" /></a>
видео


Оказалось, что даже разработчики с опытом не до конца понимают
логику обработки конструкции `finally`



# Основное в репозитории

1. Собственно примеры из опросника в [src/questionN.kt](./src) , например [src/question6.kt](src/question6.kt)
   которые собственно вызвали сложности у отвечавших
2. [src/finally_anatomy.kt](./src/finally_anatomy.kt) - тут смотрим во что примерно разворачивается `finally`
3. [src/no_guarantee.kt](./src/no_guarantee.kt) - тут простая демонстрация того, что `finally` не может магически выполниться "в любом
   случае"
4. [src/*.bytecode](./src) приложение к [src/finally_anatomy.kt](./src/finally_anatomy.kt) чтобы увидеть байткод, например
   [src/withFinallyAction.bytecode](./src/withFinallyAction.bytecode)

# Что еще возможно интересно

1. [build.gradle.kts](build.gradle.kts) просто ради интереса - мультиплатформенный конфиг с:
  - сборкой и для JVM и для Native
  - кастомные sourceSet (без вложенности src/main/kotlin, просто src)
  - сразу много exe собирается для каждого файла отдельно в Native

2. [Makefile](Makefile) просто пример того, что можно и без gradle такое собирать и в Native и в Jar

# О цикле видео обработки ошибок

В целом цикл:

1. Вступление к циклу:

<a href="https://www.youtube.com/watch?v=CXb2IAfwMY4" target="_blank"><img src="https://i9.ytimg.com/vi_webp/CXb2IAfwMY4/mqdefault.webp?v=63898224&sqp=CITMwJwG&rs=AOn4CLAUFje8usicWvBR7YJC8kmQDHMPeA" alt="вступление" width="96" height="" border="64" /></a>

Дополнительные материалы:

1. Наглядная демонстрация того как в код закрадываются ошибки, при чем тут exhusitive when, TDD, coverage

<a href="https://www.youtube.com/watch?v=4sc8-3tJN0c" target="_blank"><img src="https://i9.ytimg.com/vi_webp/4sc8-3tJN0c/mqdefault.webp?v=6374a362&sqp=CLDOwJwG&rs=AOn4CLAcMrRL8cBBu1mzDxOfTzw8GB45Ew" alt="Решение проблемы exhausitive when и coverage" width="96" height="" border="64" /></a>

