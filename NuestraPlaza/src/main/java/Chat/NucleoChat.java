package Chat;

import java.io.IOException;
import java.util.*;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/* Anotación para ServerEndpoint que, al desplegar la aplicación en el servidor,
   éste la registrará para que esté pendiente todo el tiempo...
*/
@ServerEndpoint(value="/chat", encoders={EncoderMensaje.class}, decoders={DecoderMensaje.class})
public class NucleoChat 
{
    private static final List<Session> conectados = new ArrayList<>();
    
    @OnOpen
    public void alAbrir(Session sesion)
    {
        conectados.add(sesion);
    }
    
    @OnClose
    public void alCerrar(Session sesion)
    {
        conectados.remove(sesion);
    }
    
    @OnMessage
    public void alMensaje(Mensaje mensaje) throws IOException, EncodeException
    {
        for(Session sesion : conectados)
        {
            sesion.getBasicRemote().sendObject(mensaje);
        }
    }
}

