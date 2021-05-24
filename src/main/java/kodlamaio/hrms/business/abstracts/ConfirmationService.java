package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.User;

public interface ConfirmationService {
    boolean isConfirmed(User user);
}
