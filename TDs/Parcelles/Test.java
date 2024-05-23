public class TestParcellesAgricoles {
    public static void main(String[] args) {
        try {
            // Création d'une parcelle
            Parcelle parcelle1 = new Parcelle("A", 101, 5.0);

            // Ajout d'activités de culture
            Recolte recolte1 = new Recolte("Récolte de blé", Arrays.asList(10, 20, 30), 1500, 5.0, "matin", "moissonneuse");
            parcelle1.ajouterActivite(recolte1);

            TraitementAntiInsectes traitement1 = new TraitementAntiInsectes("Traitement anti-phylloxera", Arrays.asList(5, 15, 25), 1000, 5.0, "phylloxera", "faible");
            parcelle1.ajouterActivite(traitement1);

            // Affichage des informations de la parcelle
            System.out.println(parcelle1);

            // Affichage de l'activité ayant le coût le plus élevé
            ActiviteCulture activiteMax = parcelle1.getActiviteCoutPlusEleve();
            System.out.println("Activité au coût le plus élevé : " + activiteMax);

            // Test de mise à jour du numéro de parcelle avec un numéro valide
            parcelle1.setNumeroParcelle(102);
            System.out.println("Mise à jour du numéro de parcelle : " + parcelle1);

            // Test de mise à jour du numéro de parcelle avec un numéro négatif (devrait lever une exception)
            try {
                parcelle1.setNumeroParcelle(-1);
            } catch (NumeroParcelleException e) {
                System.out.println(e.getMessage());
            }

        } catch (NumeroParcelleException e) {
            e.printStackTrace();
        }
    }
}
