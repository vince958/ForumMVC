package forum.entity;

import forum.entity.Utilisateur;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-05T17:32:35")
@StaticMetamodel(Email.class)
public class Email_ { 

    public static volatile SingularAttribute<Email, Long> id;
    public static volatile SingularAttribute<Email, String> message;
    public static volatile SingularAttribute<Email, String> objet;
    public static volatile SingularAttribute<Email, Utilisateur> owner;
    public static volatile ListAttribute<Email, Utilisateur> destinataires;

}