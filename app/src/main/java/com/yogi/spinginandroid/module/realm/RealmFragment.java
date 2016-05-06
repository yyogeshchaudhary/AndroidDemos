package com.yogi.spinginandroid.module.realm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.yogi.spinginandroid.DemoFragment;
import com.yogi.spinginandroid.R;
import com.yogi.spinginandroid.module.realm.model.Child;
import com.yogi.spinginandroid.module.realm.model.Employee;
import com.yogi.spinginandroid.module.realm.model.Person;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmModel;
import io.realm.RealmResults;


public class RealmFragment extends DemoFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_realm, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RealmConfiguration config = new RealmConfiguration.Builder(getContext()).build();

        Realm realm = Realm.getInstance(config);

        RealmResults<Person> models = realm.where(Person.class).findAll();
        if (models.size() <= 0) {
            realm.beginTransaction();
            realm.copyToRealm(getPerson());
            realm.commitTransaction();
        } else{
            ((TextView)view.findViewById(R.id.name)).setText(models.get(0).getName());
        }

    }

    public RealmModel getPerson() {
        Person person = new Person();
        person.setName("Murlidhar");
        person.setAddress("A-204, Ankoor Apt, Rambaug-2, Kalyan(W)");
        person.setPhoneNumber("+919422131866");

        Employee emp = new Employee();
        emp.setEmloyeeID(101);
        emp.setSalary(101.32);

        person.setEmployee(emp);

        RealmList<Child> childs = new RealmList<>();

        Child child1 = new Child();
        child1.setName("Yogesh");
        child1.setAge(28);
        child1.setSchool("No School");
        childs.add(child1);

        Child child2 = new Child();
        child2.setName("Mitesh");
        child2.setAge(30);
        child2.setSchool("Military School");
        childs.add(child2);
        person.setChilds(childs);

        return person;
    }
}
