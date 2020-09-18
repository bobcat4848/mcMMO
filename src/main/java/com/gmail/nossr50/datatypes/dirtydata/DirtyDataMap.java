package com.gmail.nossr50.datatypes.dirtydata;

import com.gmail.nossr50.datatypes.mutableprimitives.MutableBoolean;
import com.google.common.base.Objects;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class DirtyDataMap<K, V> implements Map<K, V> {

    private final @NotNull MutableBoolean dirtyFlag; //Can be pointed at a reference
    private @NotNull Map<K, V> dataMap;

    public DirtyDataMap(@NotNull Map<K, V> data, @NotNull MutableBoolean referenceFlag) {
        this.dataMap = data;
        this.dirtyFlag = referenceFlag;
    }

    public boolean isDirty() {
        return dirtyFlag.getImmutableCopy();
    }

    private void setDirty() {
        dirtyFlag.setBoolean(true);
    }

    public void setData(@NotNull Map<K, V> dataMap) {
        this.dataMap = dataMap;
        setDirty();
    }

    public @NotNull Map<K, V> getDataMap() {
        setDirty();
        return dataMap;
    }

    /* Map Interface Delegates */

    @Override
    public V get(Object key) {
        return dataMap.get(key);
    }

    public int size() {
        return dataMap.size();
    }

    public boolean isEmpty() {
        return dataMap.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return dataMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return dataMap.containsValue(value);
    }

    public V put(K key, V value) {
        setDirty();
        return dataMap.put(key, value);
    }

    public V remove(Object key) {
        setDirty();
        return dataMap.remove(key);
    }

    public void putAll(@NotNull Map<? extends K, ? extends V> m) {
        setDirty();
        dataMap.putAll(m);
    }

    public void clear() {
        setDirty();
        dataMap.clear();
    }

    @Override
    public @NotNull Set<K> keySet() {
        setDirty();
        return dataMap.keySet();
    }

    @Override
    public @NotNull Collection<V> values() {
        setDirty();
        return dataMap.values();
    }

    @Override
    public @NotNull Set<Map.Entry<K, V>> entrySet() {
        setDirty();
        return dataMap.entrySet();
    }

    @Override
    public V getOrDefault(Object key, V defaultValue) {
        return dataMap.getOrDefault(key, defaultValue);
    }

    @Override
    public void forEach(BiConsumer<? super K, ? super V> action) {
        setDirty();
        dataMap.forEach(action);
    }

    @Override
    public void replaceAll(BiFunction<? super K, ? super V, ? extends V> function) {
        setDirty();
        dataMap.replaceAll(function);
    }

    @Override
    public V putIfAbsent(K key, V value) {
        setDirty();
        return dataMap.putIfAbsent(key, value);
    }

    @Override
    public boolean remove(Object key, Object value) {
        setDirty();
        return dataMap.remove(key, value);
    }

    @Override
    public boolean replace(K key, V oldValue, V newValue) {
        setDirty();
        return dataMap.replace(key, oldValue, newValue);
    }

    @Override
    public V replace(K key, V value) {
        setDirty();
        return dataMap.replace(key, value);
    }

    @Override
    public V computeIfAbsent(K key, @NotNull Function<? super K, ? extends V> mappingFunction) {
        setDirty();
        return dataMap.computeIfAbsent(key, mappingFunction);
    }

    @Override
    public V computeIfPresent(K key, @NotNull BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        setDirty();
        return dataMap.computeIfPresent(key, remappingFunction);
    }

    @Override
    public V compute(K key, @NotNull BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
        setDirty();
        return dataMap.compute(key, remappingFunction);
    }

    @Override
    public V merge(K key, @NotNull V value, @NotNull BiFunction<? super V, ? super V, ? extends V> remappingFunction) {
        setDirty();
        return dataMap.merge(key, value, remappingFunction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DirtyDataMap<?, ?> that = (DirtyDataMap<?, ?>) o;
        return Objects.equal(getDataMap(), that.getDataMap());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getDataMap());
    }
}