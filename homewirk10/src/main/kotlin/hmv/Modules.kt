package hmv

import java.util.ArrayDeque
import kotlin.random.Random

fun Int.isCritical():Boolean {
    val MAX_VAL = 99
    var random = (0..MAX_VAL).random()
    return random < this
}

enum class Ammo(var default_damage: Int, var criticalDamageChance: Int, var coef: Double) {
    FIRE_BULLET(10, 25, 5.0),
    ICE_BULLET(20, 20, 10.0),
    STINKY_BULLET(30, 15, 10.0),
    ATOMIC_BULLET(40, 10, 50.0);


    fun getCurrentDamage(): Int {

        if (criticalDamageChance.isCritical()) {
            return (default_damage * coef).toInt()
        }
        return default_damage
    }

//    fun isCritical(): Boolean {
//        val MAX_VAL = 99
//        var random = (0..MAX_VAL).random()
//        val trashHold = criticalDamageChance * MAX_VAL
//        return random < trashHold
//    }
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

sealed class FireType1(open var burstsSize: Int) {
    data class BurstsFire1 (override var burstsSize: Int):FireType1 (burstsSize)  {}
    object SingleShoot: FireType1(1) {}
}

//abstract class FireType() {
//
//    abstract fun getBurstSize(): Int
//
//
//}
//
//open class BurstsFire(val burstsSize: Int) : FireType() {
//
//    override fun getBurstSize(): Int {
//        return burstsSize
//    }
//}
//
//class SingleShoot() : BurstsFire(1) { }

open class AbstractWeapon(
    val MAX_MAGAZINE_SIZE: Int,
    val fireType: FireType1,
    var magazin: WareStack<Ammo>
) {

    var defaultAmmoType_ = Ammo.FIRE_BULLET
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

    fun createAndAddStinkyBullet() {
        magazin_.push(Ammo.STINKY_BULLET)
    }
    fun createAndAddIceyBullet() {
        magazin_.push(Ammo.ICE_BULLET)
    }


    fun reloadMagazine() {
        while (magazin_.size() < MAX_MAGAZINE_SIZE_) {
            magazin_.push(defaultAmmoType_)
        }
        println("reload")
    }

    fun shoot (): Int{
        var ammos = getAmmo()
        var summarDamage = 0
        for (i in ammos) {
           if (i != null) {
               summarDamage = summarDamage + i.getCurrentDamage()
           }
        }
       println("Ammos - ${ammos.size} ${ammos[0]}, Summar Damage - ${summarDamage}")

        return summarDamage
    }

    fun getAmmo(): MutableList<Ammo?> {
        var burst = fireType_.burstsSize
        var ammos = mutableListOf<Ammo?>()
        while (burst > 0) {
            var ammo = magazin_.pop()
//            check(ammo!=null)
            if (ammo == null) {
                reloadMagazine()
                var ammo = magazin_.pop()
                ammos.add(ammo)
            } else {
                ammos.add(ammo)
            }

            --burst
        }
        return ammos
    }

    fun setBulletType(ammo: Ammo) {
        defaultAmmoType_ = ammo
    }
}

object Weapons {
    fun createPistol() = object: AbstractWeapon(7, FireType1.SingleShoot, WareStack<Ammo>()){
    }
    fun createAutomat() = object: AbstractWeapon(30, FireType1.BurstsFire1(10), WareStack<Ammo>()){
    }
    fun createBazooka() = object: AbstractWeapon(1, FireType1.SingleShoot, WareStack<Ammo>()){
    }
    fun createBow() = object: AbstractWeapon(3, FireType1.BurstsFire1(3), WareStack<Ammo>()){
    }
}


abstract class AbstractWarrior(healpoints: Int, weapon: AbstractWeapon) {
    var isKilled_ = false
    var luck_ = Random.nextInt(50, 100)
    val MAX_LEVEL_HEALPOINTS: Int = 100
    var healpoints_ = healpoints
    val weapon_ = weapon

    abstract fun attack(another_warrior: AbstractWarrior)
    abstract fun acceptDamage(damage: Int)

    fun isDead (): Boolean {
        return healpoints_ <= 0
    }
}

fun randomWeaponCapitan(): AbstractWeapon {
    val chanceWeaponGeneral = Random.nextInt(0, 100)

    return if (chanceWeaponGeneral > 50) {
       Weapons.createAutomat()
    } else Weapons.createPistol()
}

fun randomWeaponSolder(): AbstractWeapon {
    val chanceWeaponGeneral = Random.nextInt(0, 100)

    return if (chanceWeaponGeneral > 50) {
       Weapons.createPistol()
    } else Weapons.createBow()
}

fun randomWeaponGeneral(): AbstractWeapon {
    val chanceWeaponGeneral = Random.nextInt(0, 100)

    return if (chanceWeaponGeneral > 50) {
       Weapons.createBazooka()
    } else Weapons.createAutomat()
}



class General(private var weapon: AbstractWeapon = randomWeaponGeneral()) : AbstractWarrior(healpoints = 300,weapon) {
// TODO(alex) ?????????????????? ?????????????????? ?? ???????????? ????????????????, ?????????? ?????????? ???????????????????? ?????? ????????????
    init {
        var bullet = Random.nextInt(0, 100)
        if (bullet >= 50) {
            weapon_.setBulletType(Ammo.ATOMIC_BULLET)
        } else weapon_.setBulletType(Ammo.STINKY_BULLET)
    weapon_.reloadMagazine()
    }


    override fun attack(another_warrior: AbstractWarrior) {
//        if () {
//
//        }
        var DAMAGE_DONE = weapon_.shoot()
        another_warrior.acceptDamage(DAMAGE_DONE)
    }

    override fun acceptDamage(damage: Int) {
        healpoints_ = healpoints_ - damage
    }
}

class Capitan() : AbstractWarrior(healpoints = 200, randomWeaponCapitan()) {

    init {
        var bullet = Random.nextInt(0, 100)
        if (bullet >= 50) {
            weapon_.setBulletType(Ammo.STINKY_BULLET)
        } else weapon_.setBulletType(Ammo.ICE_BULLET)
        weapon_.reloadMagazine()
    }

    override fun attack(another_warrior: AbstractWarrior) {
        var DAMAGE_DONE = weapon_.shoot()
        another_warrior.acceptDamage(DAMAGE_DONE)
    }

    override fun acceptDamage(damage: Int) {
        healpoints_ = healpoints_ - damage
    }
}
class Solder() : AbstractWarrior(healpoints = 170, randomWeaponSolder()) {

    init {
        var bullet = Random.nextInt(0, 100)
        if (bullet >= 50) {
            weapon_.setBulletType(Ammo.ICE_BULLET)
        } else weapon_.setBulletType(Ammo.FIRE_BULLET)
        weapon_.reloadMagazine()
    }
    override fun attack(another_warrior: AbstractWarrior) {
        val DAMAGE_DONE = weapon_.shoot()
        another_warrior.acceptDamage(DAMAGE_DONE)
    }

    override fun acceptDamage(damage: Int) {
        healpoints_ = healpoints_ - damage
    }
}
