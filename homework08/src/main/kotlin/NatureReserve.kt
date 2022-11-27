class NatureReserve {
    private var animals_ = mutableListOf<Animal>()

    init {
        for (i in 0..2) {
            var fish = Fish (energy = 1, weight = 1, maxAge = 1, name = "Pipa${i}")
            animals_.add(fish)
        }

        for (i in 0..4) {
            var bird = Bird (energy = 1, weight = 1, maxAge = 1, name = "Boba${i}")
            animals_.add(bird)
        }

        for (i in 0..1) {
            var dog = Dog (energy = 1, weight = 1, maxAge = 1, name = "Simon${i}")
            animals_.add(dog)
        }

        for (i in 0..1) {
            var animal = Animal (energy = 1, weight = 1, maxAge = 1, name = "Pete${i}")
            animals_.add(animal)
        }
        for (i in 0..animals_.size - 1) {
            println(animals_[i].NAME_)
        }
    }
    public fun newDay () {
        for (i in 0..5) {
            var newBorns = mutableListOf<Animal>()
            animals_.forEach {
                var animal = it
                var randomOperation = (0..3).random()
                if (randomOperation == 0) {
                    animal.sleep()
                } else if (randomOperation == 1) {
                    animal.walk()
                } else if (randomOperation == 2) {
                    animal.eat()
                } else if (randomOperation == 3) {
                    var newBorn = animal.born()
                    newBorns.add(newBorn)
                } else {
                    throw IllegalArgumentException()
                }
            }

            animals_.addAll(newBorns)

            var activeAnimals = mutableListOf<Animal>()
            animals_.forEach{ animal ->
                if (animal.isActive()) {
                    activeAnimals.add(animal)
                }
            }
            animals_ = activeAnimals

            println("Чё-то родилось - ${animals_.size}")

        }
    }
}




