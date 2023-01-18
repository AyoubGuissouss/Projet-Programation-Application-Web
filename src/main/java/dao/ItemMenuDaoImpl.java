package dao;

import dao.IItemManuDao;
import entity.ItemMenu;
import util.Constantes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static util.Constantes.*;

public class ItemMenuDaoImpl implements IItemManuDao{


    /**
     * Methode pour chercher tout les items de la BD
     *
     * @return List<ItemMenu>
     */
    @Override
    public List<ItemMenu> getAllItemMenu() {
        EntityManager entityManager = null;
        List<ItemMenu> listItemsMenu = null;
        try{
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            listItemsMenu = entityManager.createQuery("select i from ItemMenu i").getResultList();
            return listItemsMenu;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            return null;
        }
    }

    /**
     * Cherche l'item par nom
     *
     * @param nom
     * @return ItemMenu
     */
    @Override
    public ItemMenu findByNom(String nom) {
        EntityManager entityManager = null;
        ItemMenu item = null;
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            item = (ItemMenu) entityManager.createNativeQuery("select * from itemmenu where nom = '" + nom + "'",ItemMenu.class).getSingleResult();
        }catch(Exception e){
            System.out.println("L'item recherché est non existant dans la base de donnée");
        }
        return item;
    }

    /**
     * Cherche l'item par tranche de prix
     *
     * @param choix
     * @return List<ItemMenu>
     */
    @Override
    public List<ItemMenu> findByPrice(int choix) {
        EntityManager entityManager = null;
        List<ItemMenu> listItem = null;
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            if(choix == 1){
                listItem = (List<ItemMenu>) entityManager.createNativeQuery("select * from itemmenu where prix < 10 ",ItemMenu.class).getResultList();
            }else if(choix == 2){
                listItem = (List<ItemMenu>) entityManager.createNativeQuery("select * from itemmenu where prix between 10 and 20 ",ItemMenu.class).getResultList();
            }else if(choix == 3){
                listItem = (List<ItemMenu>) entityManager.createNativeQuery("select * from itemmenu where prix > 20 ",ItemMenu.class).getResultList();
            }
            return listItem;
        }catch(Exception e){
            System.out.println("Aucun item dans cette tranche de prix n'est existant dans la base de donnée");
            return null;
        }
    }

    /**
     * Cherche l'item par categorie
     *
     * @param categorie
     * @return List<ItemMenu>
     */
    @Override
    public List<ItemMenu> findByCategorie(String categorie) {
        EntityManager entityManager = null;
        List<ItemMenu> listItem = null;
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            if(categorie == "Entree"){
                listItem = (List<ItemMenu>) entityManager.createNativeQuery("select * from itemmenu where categorie = 'Entree' ",ItemMenu.class).getResultList();
            }else if(categorie == "PlatPrincipal"){
                listItem = (List<ItemMenu>) entityManager.createNativeQuery("select * from itemmenu where categorie = 'PlatPrincipal' ",ItemMenu.class).getResultList();
            }else if(categorie == "Dessert"){
                listItem = (List<ItemMenu>) entityManager.createNativeQuery("select * from itemmenu where categorie = 'Dessert' ",ItemMenu.class).getResultList();
            }
            return listItem;
        }catch(Exception e){
            System.out.println("Aucun item dans cette catégorie n'est existant dans la base de donnée");
            return null;
        }
    }

    /**
     * Methode qui permet l'ajout d'un nouveau item dans la BD
     *
     * @param itemMenu
     * @return boolean
     */
    @Override
    public boolean save(ItemMenu itemMenu) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = null;
        try{
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(itemMenu);
            entityManager.getTransaction().commit();
            entityManager.close();
            return true;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Methode qui permet de modifier un item dans la BD
     * @param itemMenu a mettre a jour
     * @param nouveauItemMenu contient les modifications apporté
     * @return boolean
     */
    @Override
    public boolean update(ItemMenu itemMenu, ItemMenu nouveauItemMenu) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = null;
        try{
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.find(ItemMenu.class, itemMenu.getNom());
            itemMenu.setNom(nouveauItemMenu.getNom());
            itemMenu.setPrix(nouveauItemMenu.getPrix());
            itemMenu.setDescription(nouveauItemMenu.getDescription());
            itemMenu.setUrlPhoto(nouveauItemMenu.getUrlPhoto());
            entityManager.merge(itemMenu);
            entityManager.getTransaction().commit();
            return true;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Methode qui permet de supprimer un item de la BD
     *
     * @param itemMenu
     * @return boolean
     */
    @Override
    public boolean delete(ItemMenu itemMenu) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
        EntityManager entityManager = null;
        try{
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            itemMenu = entityManager.merge(itemMenu);
            entityManager.remove(itemMenu);
            entityManager.getTransaction().commit();
            return true;
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return false;
        }
    }

    /**
     * On va Créer une methode qui va vider
     * la table avant chaque test puis on
     * va utiliser la methode insertIntoTable pour
     * avoir la meme table avec les meme
     * enregistrement a chaque debut de test
     */
    public void viderTable(){
        EntityManager entityManager = null;
        List<ItemMenu> listItemsMenu = null;
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            listItemsMenu = entityManager.createQuery("select i from ItemMenu i").getResultList();

            for(ItemMenu itemMenu : listItemsMenu){
                entityManager.remove(itemMenu);
            }
            entityManager.getTransaction().commit();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    /**
     * On va Créer une methode insertIntoTable
     * qui va faire l'insertion de 4 enregistrement
     * dans la table ItemMenu
     * pour faire les tests
     */
    public void insertIntoTable(){
        EntityManager entityManager = null;
        ItemMenu itemMenu1 = new ItemMenu("images/Calamars.jpg","Calamars frits", descCalamars ,11.99,"Entree");
        ItemMenu itemMenu2 = new ItemMenu("images/BatonnetsFromage.jpg","Batonnets de fromage", descBatFrom,7.99,"Entree");
        ItemMenu itemMenu3 = new ItemMenu("images/BahnMi.jpg","Banh Mi", descBahnMi,15.99,"PlatPrincipal");
        ItemMenu itemMenu4 = new ItemMenu("images/Mergez.jpg","Assiette Mergez", descMergez,25.99,"PlatPrincipal");
        ItemMenu itemMenu5 = new ItemMenu("images/Nicoise.jpg","Nicoise", descNicoise,22.99,"PlatPrincipal");
        ItemMenu itemMenu6 = new ItemMenu("images/SandwichViande.jpg","Sandwich viande", descSandwich,15.99,"PlatPrincipal");
        ItemMenu itemMenu7 = new ItemMenu("images/FondantChocolat.jpg","Fondant chocolat", descFondant,8.99,"Dessert");
        ItemMenu itemMenu8 = new ItemMenu("images/GateauFromage.jpg","Gateau au frommage", descGatFrom,8.99,"Dessert");
        try {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(itemMenu1);
            entityManager.persist(itemMenu2);
            entityManager.persist(itemMenu3);
            entityManager.persist(itemMenu4);
            entityManager.persist(itemMenu5);
            entityManager.persist(itemMenu6);
            entityManager.persist(itemMenu7);
            entityManager.persist(itemMenu8);
            entityManager.getTransaction().commit();
            entityManager.close();
        }catch(Exception e){
            entityManager.getTransaction().rollback();
            e.printStackTrace();
        }
    }
}
