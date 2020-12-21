package ec.edu.ups.donBosquito.core;

import static com.sun.faces.config.WebConfiguration.WebContextInitParameter.ExpressionFactory;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;
import javax.faces.application.ViewHandler;
import javax.faces.component.UIViewRoot;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 * JSF utilities. Libreria basada el FacesUtils de Icefaces, similar a varios
 * proyectos libres, funciones adicionales agregadas para este proyecto en
 * especifico. Adaptado por Edisson Tapia
 *
 * @author ICEsoft Technologies Inc.
 * @since 2.0
 */
public class FacesUtils {

    private static Properties buildProperties = null;

//    public static void showDialog(String name) {
//        RequestContext rc = RequestContext.getCurrentInstance();
//        rc.execute("PF('" + name + "').show()");
//    }
//
//    public static void hideDialog(String name) {
//        RequestContext rc = RequestContext.getCurrentInstance();
//        rc.execute("PF('" + name + "').hide()");
//    }

    /**
     * Get servlet context.
     *
     * @return the servlet context
     */
    public static ServletContext getServletContext() {
        return (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
    }

    public static ExternalContext getExternalContext() {
        FacesContext fc = FacesContext.getCurrentInstance();
        return fc.getExternalContext();
    }

    public static HttpSession getHttpSession(boolean create) {
        try {
            return (HttpSession) FacesContext.getCurrentInstance().
                    getExternalContext().getSession(create);
        } catch (Exception e) {
        }
        return null;
    }

   
    /**
     * Store the managed bean inside the session scope.
     *
     * @param beanName the name of the managed bean to be stored
     * @param managedBean the managed bean to be stored
     */
    public static void setManagedBeanInSession(String beanName, Object managedBean) {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(beanName, managedBean);
    }

    /**
     * Store the managed bean inside the request scope.
     *
     * @param beanName the name of the managed bean to be stored
     * @param managedBean the managed bean to be stored
     */
    public static void setManagedBeanInRequest(String beanName, Object managedBean) {
        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(beanName, managedBean);
    }

    /**
     * Get parameter value from request scope.
     *
     * @param name the name of the parameter
     * @return the parameter value
     */
    public static String getRequestParameter(String name) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
    }

    /**
     * Get named request map object value from request map.
     *
     * @param name the name of the key in map
     * @return the key value if any, null otherwise.
     */
    public static Object getRequestMapValue(String name) {
        return FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(name);
    }

    /**
     * Gets the action attribute value from the specified event for the given
     * name. Action attributes are specified by &lt;f:attribute /&gt;.
     *
     * @param event
     * @param name
     * @return
     */
    public static String getActionAttribute(ActionEvent event, String name) {
        return (String) event.getComponent().getAttributes().get(name);
    }

    public static String getBuildAttribute(String name) {
        if (buildProperties != null) {
            return buildProperties.getProperty(name, "unknown");
        }
        InputStream is = null;
        try {
            is = getServletContext().getResourceAsStream("/WEB-INF/buildversion.properties");
            buildProperties = new java.util.Properties();
            buildProperties.load(is);
        } catch (Throwable e) {
            is = null;
            buildProperties = null;
            return "unknown";
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Throwable t) {
                }
            }
        }
        return buildProperties.getProperty(name, "unknown");
    }

    /**
     * Gest parameter value from the the session scope.
     *
     * @param name name of the parameter
     * @return the parameter value if any.
     */
    public static String getSessionParameter(String name) {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest myRequest = (HttpServletRequest) context.getExternalContext().getRequest();
        HttpSession mySession = myRequest.getSession();
        return myRequest.getParameter(name);
    }

    /**
     * Get parameter value from the web.xml file
     *
     * @param parameter name to look up
     * @return the value of the parameter
     */
    public static String getFacesParameter(String parameter) {
        // Get the servlet context based on the faces context
        ServletContext sc = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();

        // Return the value read from the parameter
        return sc.getInitParameter(parameter);
    }

    /**
     * Finds component with the given id
     *
     * @param c component check children of.
     * @param id id of component to search for.
     * @return found component if any.
     */
    public static UIComponent findComponent(UIComponent c, String id) {
        if (id.equals(c.getId())) {
            return c;
        }
        Iterator<UIComponent> kids = c.getFacetsAndChildren();
        while (kids.hasNext()) {
            UIComponent found = findComponent(kids.next(), id);
            if (found != null) {
                return found;
            }
        }
        return null;
    }

    /**
     * Finds all component with the given id. Component id's are formed from the
     * concatination of parent component ids. This search will find all componet
     * in the component tree with the specified id as it is possible to have the
     * same id used more then once in the component tree
     *
     * @param root component check children of.
     * @param id id of component to search for.
     * @param foundComponents list of found component with the specified id.
     * @return found component if any.
     */
    public static void findAllComponents(UIComponent root, String id,
            List<UIComponent> foundComponents) {
        if (id.equals(root.getId())) {
            foundComponents.add(root);
        }
        Iterator<UIComponent> kids = root.getFacetsAndChildren();
        while (kids.hasNext()) {
            findAllComponents(kids.next(), id, foundComponents);
        }
    }

    /**
     * Add message to a specific client.
     *
     * @param clientId the client id
     * @param type
     * @param titulo
     * @param detalle
     */
    public static void addMessage(String clientId, FacesMessage.Severity type, String titulo, String detalle) {
        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(type, titulo, detalle));
    }

    public static void msgError(String titulo, String detalle) {
        msgError(null, titulo, detalle);
    }

    public static void msgError(String clientId, String titulo, String detalle) {
        titulo = titulo == null ? "Mensaje" : titulo;
        addMessage(clientId, FacesMessage.SEVERITY_ERROR, titulo, detalle);
    }

    public static void msgWarning(String titulo, String detalle) {
        msgWarning(null, titulo, detalle);
    }

    public static void msgWarning(String clientId, String titulo, String detalle) {
        titulo = titulo == null ? "Mensaje" : titulo;
        addMessage(clientId, FacesMessage.SEVERITY_WARN, titulo, detalle);
    }

    public static void msgInfo(String titulo, String detalle) {
        msgInfo(null, titulo, detalle);
    }

    public static void msgInfo(String clientId, String titulo, String detalle) {
        titulo = titulo == null ? "Mensaje" : titulo;
        addMessage(clientId, FacesMessage.SEVERITY_INFO, titulo, detalle);
    }

    public static void msgFatal(String titulo, String detalle) {
        msgFatal(null, titulo, detalle);
    }

    public static void msgFatal(String clientId, String titulo, String detalle) {
        titulo = titulo == null ? "Mensaje" : titulo;
        addMessage(clientId, FacesMessage.SEVERITY_FATAL, titulo, detalle);
    }

    private static String getJsfEl(String value) {
        return "#{" + value + "}";
    }

    public static void redirect(String url) {
        try {
            FacesContext faces = FacesContext.getCurrentInstance();
            ExternalContext context = faces.getExternalContext();
            HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().
                    getExternalContext().
                    getRequest();
            String contextPath = request.getContextPath();
            context.redirect(contextPath + url);
            faces.responseComplete();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void disableHTTPS() {
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {

                @Override
                public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
                }

                @Override
                public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {

                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            }
        };
        try {
            SSLContext sc = SSLContext.getInstance("SSL");
            sc.init(null, trustAllCerts, new java.security.SecureRandom());
            HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        } catch (Exception e) {
        }
    }

    public static boolean isValidationFailed() {
        return FacesContext.getCurrentInstance().isValidationFailed();
    }

    public static void refreshCurrentPage() {
        FacesContext fc = FacesContext.getCurrentInstance();
        String refreshpage = fc.getViewRoot().getViewId();
        ViewHandler ViewH = fc.getApplication().getViewHandler();
        UIViewRoot UIV = ViewH.createView(fc, refreshpage);
        UIV.setViewId(refreshpage);
        fc.setViewRoot(UIV);
    }

    public static String getIpAddress() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String ipAddress = request.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = request.getRemoteAddr();
        }
        return ipAddress;
    }
    
    public static Object getManagedBean(String beanName) {
        FacesContext fc = FacesContext.getCurrentInstance();
        ELContext elc = fc.getELContext();
        ExpressionFactory ef = fc.getApplication().getExpressionFactory();
        ValueExpression ve = ef.createValueExpression(elc, getJsfEl(beanName), Object.class);
        return ve.getValue(elc);
    }
}
