package ru.sky.jrtesttask.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import ru.sky.jrtesttask.model.Component;

import java.util.Arrays;
import java.util.List;

@Repository
public class ComponentDaoImpl implements ComponentDao {

    private static final Logger logger = LoggerFactory.getLogger(ComponentDaoImpl.class);
    private SessionFactory sessionFactory = null;

    /**
     * Заглушка(в последствии будеь связываться Mysql БД и выводить значения с нее)
     *
     * @return list components
     */
    public List<Component> getAllComponents() {
        return Arrays.asList(new Component("Материнская плата", true, 10),
                new Component("HDD", true, 25),
                new Component("SSD", false, 12),
                new Component("RAM", true, 250),
                new Component("KeyBord", false, 525),
                new Component("Mouse", false, 255));
    }


    @Override
    public void addComponent(Component component) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(component);
            session.getTransaction().commit();
        } catch (Exception exc) {
            System.out.println("Session ERROR!!!!");
            exc.printStackTrace();
        }
        logger.info("Компонет добавлен. Детали : " + component);
    }

    @Override
    public void updateComponent(Component component) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(component);
            session.getTransaction().commit();
        } catch (Exception exc) {
            System.out.println("Session ERROR!!!!");
            exc.printStackTrace();
        }
        logger.info("Компонет обновлен. Детали : " + component);
    }


    @Override
    public void deleteComponent(Component component) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(component);
            session.getTransaction().commit();
        } catch (Exception exc) {
            System.out.println("Session ERROR!!!!");
            exc.printStackTrace();
        }
        logger.info("Компонет удален. Детали : " + component);
    }

    @Override
    public Component getComponentById(int id) {
        Component findComponent = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            findComponent = session.get(Component.class, id);
            session.getTransaction().commit();
        }catch (Exception exc){
            exc.printStackTrace();
        }

        logger.info(String.format("Компонент ID = [%d] найден", id));
        return findComponent;
    }

    @Override
    public List<Component> getComponentByName(String name) {
        List<Component> componentListForName = null;
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Component c where c.name = :name");
            query.setParameter("name",name);
            componentListForName = query.list();
            session.beginTransaction().commit();
        }catch (Exception exc){
            exc.printStackTrace();
        }
        logger.info(String.format("Компонент с именем = [%s] найден", name));
        return componentListForName;
    }

    @Override
    public List<Component> getAllComponentList() {
        List<Component> componentList = null;
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            componentList = session.createCriteria(Component.class).list();
            session.getTransaction().commit();
        }catch (Exception exc){
            exc.printStackTrace();
        }
        logger.info("Все компоненты получены");
        return componentList;
    }

    @Override
    public List<Component> getFilterComponentList(boolean need) {
        List<Component> componentListForNeed = null;
        try(Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from Component c where c.need = :need");
            query.setParameter("need", need);
            session.getTransaction().commit();
        }catch (Exception exc){
            exc.printStackTrace();
        }
        logger.info(String.format("кОМПОНЕНТЫ СО ЗНАЧЕНИЕМ [%s] успешно отфильтрованы", need));
        return null;
    }
}
