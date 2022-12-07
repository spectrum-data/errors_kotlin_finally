KOTLIN_FILES := $(wildcard src/*.kt)
EXECS := $(wildcard bin/*.exe)
JARS := $(wildcard bin/*.jar)

build-native: $(KOTLIN_FILES)
	mkdir -p bin
	for file in $(KOTLIN_FILES); do\
                echo Build exe for $$file; \
		kotlinc-native -o  bin/$$(basename $$file .kt) $$file; \
                mv bin/$$(basename $$file .kt).kexe bin/$$(basename $$file .kt).exe; \
	done

build-jar: $(KOTLIN_FILES)
	mkdir -p bin
	for file in $(KOTLIN_FILES); do\
		echo Build jar for $$file; \
		kotlinc $$file -include-runtime -d bin/$$(basename $$file .kt).jar; \
	done


run-native: $(EXECS)
	for file in $(EXECS); do\
		echo Run $$file; \
		./$$file; \
		echo; \
	done

run-jar: $(JARS)
	for file in $(JARS); do\
		echo Run $$file; \
		java -jar ./$$file MainKt \
		echo; \
	done

