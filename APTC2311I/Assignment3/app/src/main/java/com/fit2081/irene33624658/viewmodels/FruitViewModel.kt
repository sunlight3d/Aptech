package com.fit2081.irene33624658.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fit2081.irene33624658.models.Fruit
import com.fit2081.irene33624658.repositories.FruitRepository
import com.fit2081.irene33624658.services.LoggerService
import com.fit2081.irene33624658.services.ToastService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class FruitViewModel : ViewModel() {
    private val repository = FruitRepository()

    // Full list of Fruit
    private val _allFruits = MutableStateFlow<List<Fruit>>(emptyList())
    val allFruits: StateFlow<List<Fruit>> = _allFruits

    // Currently displayed (filtered) list of names
    private val _filteredNames = MutableStateFlow<List<String>>(emptyList())
    val filteredNames: StateFlow<List<String>> = _filteredNames

    private val _detail = MutableStateFlow<Fruit?>(null)
    val detail: StateFlow<Fruit?> = _detail

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    init {
        refreshFruits()
    }

    fun refreshFruits() {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val list = repository.loadAll()
                _allFruits.value = list
                _filteredNames.value = list.map { it.name }
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun filterBy(query: String) {
        val matches = _allFruits.value
            .filter { it.name.contains(query, ignoreCase = true) }
            .map { it.name }
        _filteredNames.value = matches
    }

    fun fetchDetail(name: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                _detail.value = repository.loadDetail(name)
            } catch (e: retrofit2.HttpException) {
                LoggerService.error("HTTP error while fetching detail", throwable = e)
                ToastService.showError("Fruit not found: $name")
                _detail.value = null
            } catch (e: Exception) {
                LoggerService.error("Unexpected error while fetching detail", throwable = e)
                ToastService.showError("Failed to fetch detail")
                _detail.value = null
            } finally {
                _isLoading.value = false
            }
        }
    }
}