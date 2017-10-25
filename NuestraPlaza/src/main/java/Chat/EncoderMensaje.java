package Chat;

import java.io.IOException;
import java.io.Writer;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

public class EncoderMensaje implements Encoder.TextStream<Mensaje>
// Esta clase se encargará de convertir el mensaje a Json
{

    @Override
    public void encode(Mensaje mensaje, Writer writer) throws EncodeException, IOException 
    {
        JsonObject json = Json.createObjectBuilder().add("nombre", mensaje.getNombre()).add("mensaje", mensaje.getMensaje()).build();
        try(JsonWriter escritor = Json.createWriter(writer))
        {
            escritor.writeObject(json);
        }
    }

    @Override
    public void init(EndpointConfig config) 
    {
        // No hacer nada
    }

    @Override
    public void destroy() 
    {
        // No hacer nada
    }
    
}
