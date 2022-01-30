package Controllers;

import Models.Entities.Employer;
import Models.EntitiesManagers.EmployersManager;
import javax.swing.JOptionPane;

public class EmployersController {

    public static boolean isValid(Employer employer) {
        if (employer.getLastName().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Le nom est manquant!");
            return false;
        } else if (employer.getFirstName().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Le prénom est manquant!");
            return false;
        } else if (employer.getBirthDate().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La date de naissance est manquante!");
            return false;
        } else if (employer.getSex().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Le sexe est manquant!");
            return false;
        } else if (employer.getTel().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Le numéro de téléphone est manquant!");
            return false;
        } else if (employer.getRule().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La fonction est manquante!");
            return false;
        }
        return true;
    }

    public static boolean store(Employer employer) {
        Employer cl = EmployersManager.get(employer.getLastName(), employer.getFirstName());
        if (cl == null) {
            if (isValid(employer)) {
                return (EmployersManager.store(employer) != null);
            } else {
                return false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "L'employer existe déjà!");
            return false;
        }
    }

    public static boolean update(int employerId, Employer employer) {
        Employer cl = EmployersManager.get(employerId);
        if (cl == null) {
            JOptionPane.showMessageDialog(null, "L'employer n'existe pas!");
            return false;
        } else {
            if (isValid(employer)) {
                return (EmployersManager.update(employerId, employer) != null);
            } else {
                return false;
            }
        }
    }

    public static boolean destroy(int employerId) {
        Employer employer = EmployersManager.get(employerId);
        if (employer == null) {
            JOptionPane.showMessageDialog(null, "L'employer sélectioné n'existe pas!");
            return false;
        } else {
            if (JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment suprimer l'employer?") == 0) {
                return (EmployersManager.delete(employerId));
            } else {
                return false;
            }
        }
    }
}
