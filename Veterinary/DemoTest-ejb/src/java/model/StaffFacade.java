/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package model;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author abspk
 */
@Stateless
public class StaffFacade extends AbstractFacade<Staff> {
    
    @PersistenceContext(unitName = "DemoTest-ejbPU")
    private EntityManager em;
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public StaffFacade() {
        super(Staff.class);
    }
    
    public boolean getLogin(String user, String pwd, SecretKeySpec key) {
        Staff m = null;
        Query q = em.createNamedQuery("Staff.findByEmail");
        //Query q = em.createQuery("SELECT e FROM Manager e WHERE e.email = :email");
        q.setParameter("email", user);
        try {
            m = (Staff) q.getSingleResult();
            if(m == null) {
                return false;
            }
        } catch(NoResultException x) {
            return false;
        }
        
        try {
           
            if(decrypt(m.getPwd(), key).equals(pwd)) {
                return true;
            }
        } catch(Exception x) {
            return false;
        }
        return false;
    }
    
    public Staff getStaff(String email) {
        Staff m = null;
        Query q = em.createNamedQuery("Staff.findByEmail");
        //Query q = em.createQuery("SELECT e FROM Manager e WHERE e.email = :email");
        q.setParameter("email", email);
        try {
            m = (Staff) q.getSingleResult();
            return m;
        } catch(NoResultException x) {
            x.printStackTrace();
            return null;
        }
    }
    
    private static String decrypt(String string, SecretKeySpec key) throws GeneralSecurityException, IOException {
        String iv = string.split(":")[0];
        String property = string.split(":")[1];
        Cipher pbeCipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        pbeCipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(base64Decode(iv)));
        return new String(pbeCipher.doFinal(base64Decode(property)), "UTF-8");
    }
    
    private static byte[] base64Decode(String property) throws IOException {
        return Base64.getDecoder().decode(property);
    }
}
