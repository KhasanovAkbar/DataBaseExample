package pdp.uz.a1_4database.models

class Phone {

    var id: Int? = null
    var group: String? = null
    var name: String? = null
    var info: String? = null

    constructor(group: String?, name: String?, info: String?) {
        this.group = group
        this.name = name
        this.info = info
    }

    constructor(id: Int?, group: String?, name: String?, info: String?) {
        this.id = id
        this.group = group
        this.name = name
        this.info = info
    }
}