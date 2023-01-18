package dao;

import entity.ItemMenu;

import java.util.List;

public interface IItemManuDao {
    /**
     * Methode pour chercher tout les items de la BD
     * @return List<ItemMenu>
     */
    List<ItemMenu> getAllItemMenu();

    /**
     * Methode qui permet l'ajout d'un nouveau item dans la BD
     * @param itemMenu
     * @return boolean
     */
    boolean save(ItemMenu itemMenu);

    /**
     * Methode qui permet de modifier un item dans la BD
     * @param itemMenu a mettre a jour
     * @param nouveauItemMenu contient les modifications apporté
     * @return boolean
     */
    boolean update(ItemMenu itemMenu, ItemMenu nouveauItemMenu);

    /**
     * Methode qui permet de supprimer un item de la BD
     * @param itemMenu
     * @return boolean
     */
    boolean delete(ItemMenu itemMenu);

    /**
     * Cherche l'item par nom
     *
     * @param nom
     * @return ItemMenu
     */
    ItemMenu findByNom(String nom);

    /**
     * Cherche l'item par tranche de prix
     *
     * @param choix
     * @return List<ItemMenu>
     */
    List<ItemMenu> findByPrice(int choix);

    /**
     * Cherche l'item par categorie
     *
     * @param categorie
     * @return List<ItemMenu>
     */
    List<ItemMenu> findByCategorie(String categorie);
}
