plugins {
    kotlin("multiplatform") version "1.7.21"
}

repositories {
    mavenCentral()
}

kotlin {
    val src = File(rootProject.projectDir, "src")
    for (f in src.listFiles().filter { it.extension == "kt" }) {
        val procName = f.nameWithoutExtension
        linuxX64(procName) {
            val mainName = procName+"Main"
            sourceSets.getByName(mainName){
                kotlin.srcDir(src).include(f.name)
            }
            binaries {
                executable(procName) {
                }
            }
        }
    }
    jvm("jvm") {
        sourceSets {
            getByName("jvmMain") {
                kotlin.srcDir(src)
            }
        }
    }
}
/*
sourceSets {
    getByName("main") {
        java.srcDir(File(rootProject.rootDir,"src"))
    }
}
 */

tasks.withType<Wrapper> {
    gradleVersion = "6.7.1"
    distributionType = Wrapper.DistributionType.BIN
}
