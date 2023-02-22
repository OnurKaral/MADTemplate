package com.onrkrl.madtemplate.data.local.dao

import androidx.room.*
import com.onrkrl.core.BaseEntity
import com.onrkrl.madtemplate.data.remote.utils.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao : BaseDao<BaseEntity> {
    @Query("SELECT * FROM ${Constants.TABLE_NAME}")
    fun getEntity(): Flow<List<BaseEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntity(entity: BaseEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateEntity(entity: BaseEntity)

    @Delete
    suspend fun deleteEntity(entity: BaseEntity)

    @Query("DELETE FROM ${Constants.TABLE_NAME}")
    suspend fun deleteAll()

}