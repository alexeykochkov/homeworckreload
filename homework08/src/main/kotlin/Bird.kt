class Bird(energy: Int, weight: Int, maxAge: Int, name: String) :
    Animal(energy, weight, maxAge, name) {

    override fun walk() {
        super.walk()
        println("Bird is flyinght")
    }

    override fun born(): Animal {
        var animal = Bird (energy = generateEnergy(),
            weight = genereteWeight(),
            maxAge = MAX_AGE_,
            name = NAME_
        )
        println("Bird was burn ${animal.energy_} ${animal.weight_} ${animal.NAME_} ${animal.MAX_AGE_}" )
        return animal
    }

}