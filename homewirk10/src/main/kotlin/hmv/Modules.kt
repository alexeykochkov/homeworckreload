package hmv

import java.util.ArrayDeque
import kotlin.random.Random

enum class Ammo(var damage: Int, var criticalDamageChance: Double, var coef: Double) {
    FIRE_BULLET(10, 0.25, 5.0),
    ICE_BULLET(20, 0.20, 10.0),
    ATOMIC_BULLET(40, 0.10, 50.0);


    fun getCurrentDamage(): Int {
        if (isCritical()) {
            return (damage * coef).toInt()
        }
        return damage
    }

    fun isCritical(): Boolean {
        val MAX_VAL = 99
        var random = (0..MAX_VAL).random()
        val trashHold = criticalDamageChance * MAX_VAL
        return random < trashHold
    }
}


class WareStack<T>() {
    private var stack_ = ArrayDeque<T>()

    fun size(): Int {
        return stack_.size
    }

    fun push(item: T) {
        stack_.push(item)
    }

    fun pop(): T? {
        if (isEmpty()) {
            return null
        } else {
            return stack_.pop()
        }
    }

    fun isEmpty(): Boolean {
        return stack_.isEmpty()
    }
}

abstract class FireType() {

    abstract fun getBurstSize(): Int


}

open class BurstsFire(val burstsSize: Int) : FireType() {

    override fun getBurstSize(): Int {
        return burstsSize
    }
}

class SingleShoot() : BurstsFire(1) { }

open class AbstractWeapon(
    val MAX_MAGAZINE_SIZE: Int,
    val fireType: FireType,
    var magazin: WareStack<Ammo>
) {

    val MAX_MAGAZINE_SIZE_ = MAX_MAGAZINE_SIZE
    val fireType_ = fireType
    val magazin_ = magazin

    fun isEmpty(): Boolean {
        return magazin_.isEmpty()
    }

    fun createAndAddAtomicBullet() {
        magazin_.push(Ammo.ATOMIC_BULLET)
    }

    fun createAndAddFireBullet() {
        magazin_.push(Ammo.FIRE_BULLET)
    }

    fun reloadMagazine() {
        while (magazin_.size() < MAX_MAGAZINE_SIZE_) {
            magazin_.push(Ammo.FIRE_BULLET)
        }
    }

    fun getAmmo(): MutableList<Ammo?> {
        var burst = fireType_.getBurstSize()
        var ammos = mutableListOf<Ammo?>()
        while (burst > 0) {
            ammos.add(magazin_.pop())
        }
        return ammos
    }
}

class Pistol() : AbstractWeapon(7, SingleShoot(), WareStack<Ammo>()) {

}

class Automat() : AbstractWeapon(30, BurstsFire(10), WareStack<Ammo>()) {

}

class Bazooka() : AbstractWeapon(1, SingleShoot(), WareStack<Ammo>()) {

}

class Bow() : AbstractWeapon(7, BurstsFire(3), WareStack<Ammo>()) {

}

abstract class AbstractWarrior(healpoints: Int, weapon: AbstractWeapon) {
    var isKilled_ = false
    var luck_ = Random.nextInt(50, 100)
    val MAX_LEVEL_HEALPOINTS: Int = 100
    var healpoints_ = healpoints
    val weapon_ = weapon

    abstract fun attack(another_warrior: AbstractWarrior)
    abstract fun acceptDamage(damage: Int)
}

class General() : AbstractWarrior(healpoints = 300, Bazooka()) {

    private val DAMAGE_DONE = 100

    override fun attack(another_warrior: AbstractWarrior) {
        another_warrior.acceptDamage(DAMAGE_DONE)
    }

    override fun acceptDamage(damage: Int) {
        healpoints_ = healpoints_ - damage
    }
}

class Capitan() : AbstractWarrior(healpoints = 200, Automat()) {

    private val DAMAGE_DONE = 200

    override fun attack(another_warrior: AbstractWarrior) {
        another_warrior.acceptDamage(DAMAGE_DONE)
    }

    override fun acceptDamage(damage: Int) {
        healpoints_ = healpoints_ - damage
    }
}

class Solder() : AbstractWarrior(healpoints = 100, Pistol()) {

    private val DAMAGE_DONE = 200

    override fun attack(another_warrior: AbstractWarrior) {
        another_warrior.acceptDamage(DAMAGE_DONE)
    }

    override fun acceptDamage(damage: Int) {
        healpoints_ = healpoints_ - damage
    }
}
