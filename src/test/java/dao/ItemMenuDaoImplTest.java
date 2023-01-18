package dao;

import entity.ItemMenu;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ItemMenuDaoImplTest {
    private ItemMenuDaoImpl itemMenuDao;

    @BeforeEach
    void setUp() {
        System.out.println("@BeforeEach");
        itemMenuDao = new ItemMenuDaoImpl();
        itemMenuDao.viderTable();
        itemMenuDao.insertIntoTable();
    }

    @AfterEach
    void tearDown() {
        System.out.println("@AfterEach");
    }

    @Test
    void testGetAllItemMenuRetourneTailleListeNonVide() {
        System.out.println("testGetAllItemMenuRetourneTailleListeNonVide");
        List<ItemMenu> list = itemMenuDao.getAllItemMenu();
        //Verifier que la liste retourne est non null
        Assert.assertNotNull(list);
        //Verifier que la taille de la liste est de 4
        Assert.assertEquals(8,list.size());
    }

    @Test
    void testSaveRetourneTrue() {
        System.out.println("testSaveRetourneTrue");
        //Créer un nouveau item
        ItemMenu itemMenu = new ItemMenu("images/CarreVeau.jpg","Carré de veau", "gwegweg",30.99,"PlatPrincipal");
        //Ajouter l'item
        Boolean itemAjoute = itemMenuDao.save(itemMenu);
        Assert.assertTrue(itemAjoute);
    }

    @Test
    void testUpdateRetourneTrue() {
        System.out.println("testUpdateRetourneTrue");
        ItemMenu itemMenu = new ItemMenu("images/BahnMi.jpg","Banh Mi", "gwegweg",15.99,"PlatPrincipal");
        ItemMenu nouveauItemMenu = new ItemMenu("images/BahnMi.jpg","Banh Mi", "gwegweg",16.99,"PlatPrincipal");

        Boolean itemMisAJour = itemMenuDao.update(itemMenu, nouveauItemMenu);
        Assert.assertTrue(itemMisAJour);

    }

    @Test
    void testDeletRetourneTrue() {
        System.out.println("testDeletRetourneTrue");
        ItemMenu itemMenu = new ItemMenu("images/BahnMi.jpg","Banh Mi", "gwegweg",15.99,"PlatPrincipal");

        Boolean itemSuprime = itemMenuDao.delete(itemMenu);
        Assert.assertTrue(itemSuprime);
    }

    @Test
    void testFindByNomRetourneNotNull() {
        System.out.println("testFindByNomReturnsTrue");

        ItemMenu itemTest = itemMenuDao.findByNom("Banh Mi");
        Assert.assertNotNull(itemTest);
        System.out.println(itemTest);
    }

    @Test
    void testFindByPriceChoix1RetourneTailleList2() {
        System.out.println("testFindByPriceChoix1RetourneTailleList2");
        List<ItemMenu> list = itemMenuDao.findByPrice(1);
        Assert.assertEquals(3,list.size());
    }

    @Test
    void testFindByPriceChoix2RetourneTailleList3() {
        System.out.println("testFindByPriceChoix1RetourneTailleList2");
        List<ItemMenu> list = itemMenuDao.findByPrice(2);
        Assert.assertEquals(3,list.size());
    }

    @Test
    void testFindByPriceChoix3RetourneTailleList2() {
        System.out.println("testFindByPriceChoix1RetourneTailleList2");
        List<ItemMenu> list = itemMenuDao.findByPrice(3);
        Assert.assertEquals(2,list.size());
    }

    @Test
    void testFindByCategorieEntreeRetourneTailleList2() {
        System.out.println("testFindByCategorieEntreeRetourneTailleList2");
        List<ItemMenu> list = itemMenuDao.findByCategorie("Entree");
        Assert.assertEquals(2,list.size());
    }

    @Test
    void testFindByCategoriePlatPrincipalRetourneTailleList4() {
        System.out.println("testFindByCategorieEntreeRetourneTailleList2");
        List<ItemMenu> list = itemMenuDao.findByCategorie("PlatPrincipal");
        Assert.assertEquals(4,list.size());
    }

    @Test
    void testFindByCategorieDessertRetourneTailleList2() {
        System.out.println("testFindByCategorieEntreeRetourneTailleList2");
        List<ItemMenu> list = itemMenuDao.findByCategorie("Dessert");
        Assert.assertEquals(2,list.size());
    }

    @Test
    void test() {
        System.out.println(System.getProperty("user.dir"));
    }
}