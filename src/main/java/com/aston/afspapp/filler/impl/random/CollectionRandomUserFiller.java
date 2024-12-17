package com.aston.afspapp.filler.impl.random;

import com.aston.afspapp.context.CustomContext;
import com.aston.afspapp.service.Util.RandomNameUtil;
import com.aston.afspapp.service.Util.RandomPasswordUtil;
import com.aston.afspapp.entity.User;
import com.aston.afspapp.filler.FillCollection;

import java.util.List;

public class CollectionRandomUserFiller implements FillCollection<User> {
    @Override
    public void fillCollection(List<User> list) {
        String name;
        String pasword;
        String email;
        int size = CustomContext.INSTANCE.getCurrCollectionSize();
        for (int i = 0; i < size; i++) {
            name = RandomNameUtil.createName();
            pasword = RandomPasswordUtil.createPassword();
            email = name + "@gmail.com";
            User user = new User(name, pasword, email);
            list.add(user);
        }
    }
}
