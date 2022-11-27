class Dog (energy: Int, weight: Int, maxAge: Int, name: String) :
    Animal(energy, weight, maxAge, name) {

    override fun walk() {
        super.walk()
        println("Dog is run")
    }
    override fun born(): Animal {
        var animal = Dog (energy = generateEnergy(),
            weight = genereteWeight(),
            maxAge = MAX_AGE_,
            name = NAME_
        )
        println("Dog was burn ${animal.energy_} ${animal.weight_} ${animal.NAME_} ${animal.MAX_AGE_}" )
        return animal
    }
}