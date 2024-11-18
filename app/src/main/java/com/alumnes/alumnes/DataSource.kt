package com.alumnes.alumnes

data class Alumne(val name: String, val age: Int, val course: String)

class DataSource private constructor() {
    val alumneList: MutableList<Alumne> = arrayListOf(
        Alumne("John Smith", 18, "1R DAM"),
        Alumne("Jane Doe", 19, "2N DAM"),
        Alumne("Alice Johnson", 17, "1R SMX"),
        Alumne("Bob Brown", 18, "2N SMX"),
        Alumne("Charlie Davis", 18, "1R BTX"),
        Alumne("Diana Evans", 19, "2N BTX"),
        Alumne("Ethan Wilson", 18, "1R DAM"),
        Alumne("Fiona Harris", 20, "2N DAM"),
        Alumne("George Clark", 16, "1R SMX"),
        Alumne("Hannah Lewis", 18, "2N SMX"),
        Alumne("Ian Walker", 17, "1R BTX"),
        Alumne("Julia Hall", 18, "2N BTX"),
        Alumne("Kevin Young", 18, "1R DAM"),
        Alumne("Laura King", 19, "2N DAM"),
        Alumne("Michael Scott", 17, "1R SMX"),
        Alumne("Natalie Martinez", 18, "2N SMX"),
        Alumne("Oliver Roberts", 18, "1R BTX"),
        Alumne("Patricia White", 20, "2N BTX"),
        Alumne("Quentin Miller", 16, "1R DAM"),
        Alumne("Rebecca Lopez", 18, "2N DAM"),
        Alumne("Samuel Anderson", 17, "1R SMX"),
        Alumne("Tina Thompson", 18, "2N SMX"),
        Alumne("Ulysses Baker", 18, "1R BTX"),
        Alumne("Victoria Green", 19, "2N BTX"),
        Alumne("William Adams", 18, "1R DAM"),
        Alumne("Xenia Gonzalez", 20, "2N DAM"),
        Alumne("Yvonne Perez", 16, "1R SMX"),
        Alumne("Zachary Turner", 18, "2N SMX"),
        Alumne("Amy Scott", 17, "1R BTX"),
        Alumne("Brandon Lee", 18, "2N BTX")
    )

    companion object {
        val instance: DataSource by lazy { DataSource() }
    }

}
