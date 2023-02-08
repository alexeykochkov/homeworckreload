import hmv.*
import kotlin.random.Random


fun test0() {
    var a = Ammo.FIRE_BULLET
    var damage1 = a.getCurrentDamage()
    var b = Ammo.ATOMIC_BULLET
    var damage2 = b.getCurrentDamage()
}

class Weapons() {
    fun createPistol(): AbstractWeapon {
        return Pistol()
    }

    fun createAutomate(): AbstractWeapon {
        return Automat()
    }

    fun createBazooka(): AbstractWeapon {
        return Bazooka()
    }

    fun createBow(): AbstractWeapon {
        return Bow()
    }
}


/////////////////////////////////////
class Team() {

    fun create(targetTeamSize: Int = 20): MutableList<AbstractWarrior> {
        var team = mutableListOf<AbstractWarrior>()
        for (e in 0..targetTeamSize - 1) {
            var luck = Random.nextInt(0, 99)
            if (luck < 10) {
                team.add(General())
            } else if (luck < 50) {
                team.add(Capitan())
            } else {
                team.add(Solder())
            }
        }
        return team
    }
}

class Battle() {
    var teamOne_ = Team().create()
    var teamTwo_ = Team().create()
    var finished_ = false

    fun iterate() {
             // fight
        for (i in 0..teamOne_.size - 1) {
            teamOne_[i].attack(teamTwo_[teamOne_.size - 1 - i])
            for (j in 0..teamOne_.size - 1) {
                teamOne_[i].attack(teamTwo_[j])
            }
            teamTwo_[i].attack(teamOne_[i])
        }

        println(teamOne_.size)


        // remoove killed
        teamOne_.forEach { warrior: AbstractWarrior ->
            if (warrior.healpoints_ <= 0)
                teamOne_.remove(warrior)
//            army = battle
        }
        teamTwo_.forEach { warrior: AbstractWarrior ->
            if (warrior.healpoints_ <= 0)
                teamTwo_.remove(warrior)
//            army = battle
        }

//        var iterator = army.iterator()
//        while (iterator.hasNext()) {
//            val item = iterator.next()
//            if (item.healpoints_ <= 0) {
//                army.remove(item)
//        println(army)

    }

}


fun main() {

    var battle = Battle()

    while (!battle.finished_) {
        battle.iterate()
    }
}

