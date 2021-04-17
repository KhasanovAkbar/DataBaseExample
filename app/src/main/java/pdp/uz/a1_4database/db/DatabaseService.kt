package pdp.uz.a1_4database.db

import pdp.uz.a1_4database.models.Phone

interface DatabaseService {

    fun addPhone(phone: Phone)

    fun getPhoneById(id: Int): Phone

    fun getAllPhones(): ArrayList<Phone>
}