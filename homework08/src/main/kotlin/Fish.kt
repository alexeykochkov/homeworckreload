class Fish (energy: Int, weight: Int, maxAge: Int, name: String) :
    Animal(energy, weight, maxAge, name) {

    override fun walk() {
        super.walk()
        println("Fish is swim")
    }
    override fun born(): Animal {
        var animal = Fish (energy = generateEnergy(),
            weight = genereteWeight(),
            maxAge = MAX_AGE_,
            name = NAME_
        )
        println("Fish was burn ${animal.energy_} ${animal.weight_} ${animal.NAME_} ${animal.MAX_AGE_}" )
        return animal
    }
}