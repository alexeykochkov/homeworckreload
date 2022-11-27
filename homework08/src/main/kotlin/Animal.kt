import kotlin.random.Random

open class  Animal (energy: Int, weight: Int, maxAge: Int, name: String) {
    protected var energy_: Int
    protected var weight_: Int
    private var currentAge_: Int
    public val MAX_AGE_: Int
    public val NAME_: String

    init {
        energy_ = energy
        weight_ = weight
        currentAge_ = 0
        MAX_AGE_ = maxAge
        NAME_ = name
    }
    public fun isTooOld (): Boolean {
        if (currentAge_ >= MAX_AGE_) {
            return true
        } else {
            return false
        }
    }
    public fun getEnergy ():Int {
        return energy_
    }

    public fun sleep () {
        if (!isActive()) {
            println("I am dead")
            return
        }
        energy_ = energy_ + 5
        currentAge_ = currentAge_ + 1
        println("${NAME_} sleep")
        checkInvariants()
    }

    public fun eat () {
        if (!isActive()) {
            println("I am dead")
            return
        }
        energy_ = energy_ + 3
        weight_ = weight_ + 1
        tryIncrementAge()
        checkInvariants()
    }

    public open fun walk () {
        if (!isActive()) {
            println("I am dead")
            return
        }
        val energy = energy_ - 5
        val weight = weight_ - 1

        energy_ = energy
        weight_ = weight
        tryIncrementAge()
        println("${NAME_} walk")
        checkInvariants()
    }
    private fun tryIncrementAge () {
        if (Random.nextBoolean()) {
            currentAge_ = currentAge_ + 1
        }
    }

    private fun isNotEnoughtWeight (): Boolean {
        return weight_ <= 0
    }
    private  fun isNotEnoughtEnergy (): Boolean {
        return  energy_ <= 0
    }
    fun isActive (): Boolean {
        if (isTooOld())
            return false
        if (isNotEnoughtWeight())
            return false
        if (isNotEnoughtEnergy())
            return false
        return true
    }
    open fun born (): Animal {
        var animal = Animal (energy = generateEnergy(),
            weight = genereteWeight(),
            maxAge = MAX_AGE_,
            name = NAME_
        )
        println("Animal was burn ${animal.energy_} ${animal.weight_} ${animal.NAME_} ${animal.MAX_AGE_}" )
        return animal
    }
    protected fun generateEnergy (): Int {
        val randomEnergy = (1..10).random()
        return randomEnergy
    }
    protected fun genereteWeight (): Int {
        val randomWeight = (1..5).random()
        return randomWeight
    }

    private fun checkInvariants() {
//        check(energy_ >= 0)
//        check(weight_ >= 0)
    }
}
