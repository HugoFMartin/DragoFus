package com.hugofmartin.dragofus.data.repository

import com.hugofmartin.dragofus.common.Constants
import com.hugofmartin.dragofus.data.database.DatabaseManager
import com.hugofmartin.dragofus.data.database.dao.DragodindeDao
import com.hugofmartin.dragofus.data.entity.Dragodinde
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

interface DragodindeRepository {
    val allDragodindes: Flow<List<Dragodinde>>
    val femaleDragodindes: Flow<List<Dragodinde>>
    val maleDragodindes: Flow<List<Dragodinde>>
    suspend fun addDragodinde(dragodinde: Dragodinde)
    suspend fun deleteDragodinde(dragodindeId: Dragodinde)
    suspend fun makeUnFertile(dragodindeId: Int)
    suspend fun makeFertile(dragodindeId: Int)
    suspend fun makePregnant(femaleDragodindeId: Int)
    suspend fun decrementCoupling(dragodindeId: Int)

    companion object {
        fun newInstance(): DragodindeRepository =
            DragondindeRepositoryImpl(
                DatabaseManager.getInstance().database.dragodindeDao
            )
    }
}

class DragondindeRepositoryImpl(
    private val dragodindeDao: DragodindeDao
) : DragodindeRepository {

    override val allDragodindes: Flow<List<Dragodinde>> = dragodindeDao.getAll()
    override val femaleDragodindes: Flow<List<Dragodinde>> = dragodindeDao.getFemaleDragodindes()
    override val maleDragodindes: Flow<List<Dragodinde>> = dragodindeDao.getMaleDragodindes()

    override suspend fun addDragodinde(dragodinde: Dragodinde) {
        withContext(Dispatchers.IO){
            dragodindeDao.insert(dragodinde)
        }
    }

    override suspend fun deleteDragodinde(dragodindeId: Dragodinde){
        withContext(Dispatchers.IO) {
            dragodindeDao.delete(dragodindeId)
        }
    }

    override suspend fun makeUnFertile(dragodindeId: Int) {
        withContext(Dispatchers.IO) {
            dragodindeDao.makeUnFertile(dragodindeId)
        }
    }

    override suspend fun makeFertile(dragodindeId: Int) {
        withContext(Dispatchers.IO) {
            dragodindeDao.makeFertile(dragodindeId)
        }
    }

    override suspend fun makePregnant(femaleDragodindeId: Int) {
        withContext(Dispatchers.IO) {
            dragodindeDao.makePregnant(femaleDragodindeId)
        }
    }

    override suspend fun decrementCoupling(dragodindeId: Int) {
        withContext(Dispatchers.IO) {
            dragodindeDao.decrementCoupling(dragodindeId)
        }
    }
}
