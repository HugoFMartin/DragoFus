package com.hugofmartin.dragofus.data.repository

import com.hugofmartin.dragofus.data.database.DatabaseManager
import com.hugofmartin.dragofus.data.database.dao.CouplingDao
import com.hugofmartin.dragofus.data.entity.Coupling
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

interface CouplingRepository {
    val allCouplings: Flow<List<Coupling>>
    suspend fun addCoupling(coupling: Coupling)
    suspend fun makeCouplingFinished(couplingId: Int)

    companion object {
        fun newInstance(): CouplingRepository =
            CouplingRepositoryImpl(
                DatabaseManager.getInstance().database.couplingDao
            )
    }
}

class CouplingRepositoryImpl(
    private val couplingDao: CouplingDao
) : CouplingRepository {

    override val allCouplings = couplingDao.getCouplings()

    override suspend fun addCoupling(coupling: Coupling) {
        withContext(Dispatchers.IO) {
            couplingDao.insert(coupling)
        }
    }

    override suspend fun makeCouplingFinished(couplingId: Int) {
        withContext(Dispatchers.IO) {
            couplingDao.makeCouplingFinished(couplingId)
        }
    }
}
