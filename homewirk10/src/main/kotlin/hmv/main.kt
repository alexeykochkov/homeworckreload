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


fun main() {
//    var healpoints: Int = 10
//    val worrior1 = Pion (healpoints)
//    val worrior2 = Pion (20)
//    worrior1.attack(worrior2)
//    println(worrior2.healpoints_)
//    var army = createFakeArmy()
//    var army1 = createFakeArmy()
//    var battle = mutableListOf<Warrior>()

    var stack = WareStack<Ammo>()
    stack.push(Ammo.ATOMIC_BULLET)
    stack.push(Ammo.FIRE_BULLET)
    var w1 = stack.pop()


    fun fight(): MutableList<AbstractWarrior> {
//        var pion = Pion(healpoints = 1)
//        var zerg = Zerg(healpoints = 2)
//
        // create armys
        var army = createFakeArmy()
        var army2 = createFakeArmy()

        // fight
        for (i in 0..army.size - 1) {
            army[i].attack(army2[army.size - 1 - i])
            for (j in 0..army.size - 1) {
                army[i].attack(army2[j])
            }
            army2[i].attack(army[i])
        }

        println(army.size)


        // remoove killed
        army.forEach { warrior: AbstractWarrior ->
            if (warrior.healpoints_ <= 0)
                army.remove(warrior)
//            army = battle
        }
        army2.forEach { warrior: AbstractWarrior ->
            if (warrior.healpoints_ <= 0)
                army2.remove(warrior)
//            army = battle
        }

//        var iterator = army.iterator()
//        while (iterator.hasNext()) {
//            val item = iterator.next()
//            if (item.healpoints_ <= 0) {
//                army.remove(item)
//        println(army)
        return army
    }
//    println(battle)


    var army = fight()
    val zerg = army[0].healpoints_


    println(fight())

}


//        army.forEach {
//            pion.attack(zerg)
//
//            if (pion.healpoints_ <= 0) {
//                army.remove(pion)
//
//            }
//            if (zerg.healpoints_ <= 0) {
//                army.remove(zerg)
//
//            }
//
//        }
//        println(pion.healpoints_)

//
//        }
//        println(army)
//    }
//    fight()
//}


//        println("Create computer army")
//        var army1 = createFakeArmy()
//

//        pion.attack(zerg)
//        itterator0.forEach {
//            val item = itterator0.next().toString()
//            println(item)
//            if (item.healpoints_ <= 0) {
//                for (element in army) {army.clear(element))}
//                itterator0.remove()
//                army.clear()


//        println("1111111111111111${army}")
//            while (itterator0.hasNext()) {
//                army.forEach {
//
//
//                    if () {
//                        itterator0.remove()
//
//
//                    }
//                }
//
//            }
//            println("Pion1 Player HP - ${army}")
//            println("Pion1 Player HP - ${itterator0}")
//            println("Pion1 Player HP - ${pion.healpoints_}")
//            println("Zerg1 Player HP - ${zerg.healpoints_}")

//        println(army)
//        army1.forEach() {
//            zerg.attack(pion)
//            pion.attack(zerg)
//            while (iterator1.hasNext()) {
//                val item = iterator1.next()
//                if (item.healpoints_ <= 0) {
//                    iterator1.remove()
//                    println("Pion Computer HP - ${pion.healpoints_}")
//                    println("Zerg Computer HP - ${zerg.healpoints_}")
//                }
//            }
//        }


//    fun battle(warrior1: Warrior, warrior2: Warrior) {
//        var army = createFakeArmy()
//        var army1 = createFakeArmy()
//        val worrior1 = army
//        val worrior2 = army1
//        worrior1.forEach{
//            fight(worrior1 = warrior1, worrior2 = warrior2)
//            println("Zerg ${warrior1.healpoints_}\nPion ${warrior2.healpoints_}")
//        }
//        worrior2.forEach{
//            fight(worrior1 = warrior2, worrior2 = warrior1)
//            println("Zerg ${warrior2.healpoints_}\nPion ${warrior1.healpoints_}")
//        }
//
//        for (index in army) {
//            worrior1.attack(worrior2)
//            println("Pions${worrior1.healpoints_}")
//        }
//        for (index in army1) {
//            worrior2.attack(worrior1)
//            println("Zergs${worrior2.healpoints_}")
//        }
//        if (worrior2.healpoints_ <= 0 || worrior1.healpoints_ <= 0) {
//            println("Combat compleat")
//
//        }


//    val myCollection = mutableListOf(1,2,3,4)
//    val iterator = myCollection.iterator()
//    while(iterator.hasNext()){
//        val item = iterator.next()
//        if(item == 3){
//            iterator.remove()
//            println(myCollection)
//        }
//    }


//    var healpoints: Int = 10
//    val worrior1 = Pion (healpoints)
//    val worrior2 = Zerg (20)
//    val worrior1 = army[1]
////    val worrior2 = army1 [0]
//        while (true) {
//            val worrior1 = army[0]
//            val worrior2 = army1[1]
//            fight(worrior1 = worrior1, worrior2 = worrior2)
//            println("Zerg ${worrior2.healpoints_}\nPion ${worrior1.healpoints_}")
//            println("[!]")
//            println("Army player${army.indices}\nArmy computer ${army1.indices}")
//            println("[!]")
//            if (worrior2.healpoints_ <= 0 || worrior1.healpoints_ <= 0) {
//                println("Combat compleat")
//                break
//            }