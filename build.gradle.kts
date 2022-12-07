plugins {
    kotlin("multiplatform") version "1.7.21"
}
repositories {
    mavenCentral()
}
kotlin {


    val src = File(rootProject.projectDir, "src")

    jvm("jvm") {
        sourceSets {
            getByName("jvmMain") {
                kotlin.srcDir(src)
            }
        }
    }

    for (f in src.listFiles().filter { it.extension == "kt" }) {
        val procName = f.nameWithoutExtension
        if (f.readText().contains("java.")) {
            continue
        }
        linuxX64(procName) {
            val mainName = procName + "Main"
            sourceSets.getByName(mainName) {
                kotlin.srcDir(src).include(f.name)
            }
            binaries {
                executable(procName) {
                }
            }
        }
    }

}
