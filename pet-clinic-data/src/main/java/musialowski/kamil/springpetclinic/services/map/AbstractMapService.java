package musialowski.kamil.springpetclinic.services.map;

import musialowski.kamil.springpetclinic.model.BaseEntity;

import java.util.*;

public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    T save(T object) {

        if(object!=null) {
            if(object.getId() == null) {
                object.setId(this.nextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object passed to map cannot be null!");
        }
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long nextId() {
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch(NoSuchElementException e) {
            nextId = 1L;
        }

        return nextId;
    }
}
