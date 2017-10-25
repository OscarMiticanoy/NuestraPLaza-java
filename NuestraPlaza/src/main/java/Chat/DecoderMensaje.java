package Chat;

import java.io.IOException;
import java.io.Reader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class DecoderMensaje implements Decoder.TextStream<Mensaje>
// Esta clase se encargará de convertir un Json a mensaje
{

    @Override
    public Mensaje decode(Reader reader) throws DecodeException, IOException 
    {
        Mensaje mensaje = new Mensaje();
        try(JsonReader lector = Json.createReader(reader))
        {
            
            JsonObject json = lector.readObject();
            mensaje.setNombre(json.getString("nombre"));
            mensaje.setMensaje(json.getString("mensaje"));
        }
        return mensaje;
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