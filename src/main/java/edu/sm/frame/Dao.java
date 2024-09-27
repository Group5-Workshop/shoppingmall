package edu.sm.frame;

import java.sql.Connection;
import java.util.List;

public interface Dao<K, V> {
    V insert(V v, Connection con) throws Exception;
    V update(V v, Connection con) throws Exception;
    boolean delete(K k, Connection con) throws Exception;
    V select(K k, Connection con) throws Exception;
}
