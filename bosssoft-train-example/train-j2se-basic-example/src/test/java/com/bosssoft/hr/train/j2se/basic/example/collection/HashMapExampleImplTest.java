package com.bosssoft.hr.train.j2se.basic.example.collection;

import com.bosssoft.hr.train.j2se.basic.example.pojo.Resource;
import com.bosssoft.hr.train.j2se.basic.example.pojo.Role;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapExampleImplTest {
    HashMapExampleImpl hashMapExample;
    Role role;
    Resource resource;

    @Before
    public void setUp() throws Exception {
        hashMapExample = new HashMapExampleImpl();
        role = new Role(1, "boss");
        resource = new Resource(1, "all");
    }

    @After
    public void tearDown() throws Exception {
        hashMapExample = null;
        role = null;
        resource = null;
    }

    @Test
    public void put() {
        // hashMap 允许null作为key
        hashMapExample.put(null, null);
        // 放入值 由于第一次为null
        assertNull(hashMapExample.put(this.role, this.resource));
        Resource resource = hashMapExample.put(this.role, this.resource);
        assertEquals(this.resource, resource);
    }

    @Test
    public void remove() {
        assertNull(hashMapExample.put(this.role, this.resource));
        assertEquals(this.resource, hashMapExample.remove(role));
    }

    @Test
    public void containsKey() {
        assertNull(hashMapExample.put(this.role, this.resource));
        assertTrue(hashMapExample.containsKey(this.role));
        assertFalse(hashMapExample.containsKey(null));

    }

    @Test
    public void visitByEntryset() {
        assertNull(hashMapExample.put(null, null));
        assertNull(hashMapExample.put(this.role, this.resource));
        hashMapExample.visitByEntryset();
    }

    @Test
    public void visitByKeyset() {
        assertNull(hashMapExample.put(null, null));
        assertNull(hashMapExample.put(this.role, this.resource));
        hashMapExample.visitByKeyset();
    }

    @Test
    public void visitByValues() {
        assertNull(hashMapExample.put(null, null));
        assertNull(hashMapExample.put(this.role, this.resource));
        hashMapExample.visitByValues();
    }
}