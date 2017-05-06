package org.dao.daoi;

import org.entity.Group;

import java.util.List;

/**
 * Created by AMakas on 08.02.2017.
 */
public interface IGroup {
    public boolean add(Group group);

    public boolean delete(Group group);

    public void update(Group group);

    public List<Group> getAll();

    public Group getById(int id);

    public List<Group> getByName(String string);

    public String getError();

}
