package com.sweetitech.tiger.model.cricketapi;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CricketApiLogin {
    private String status_code;

    private String expires;

    private String status;

    private String cache_key;

    private String Etag;

    private Auth auth;

    private String version;

    public String getStatus_code ()
    {
        return status_code;
    }

    public void setStatus_code (String status_code)
    {
        this.status_code = status_code;
    }

    public String getExpires ()
    {
        return expires;
    }

    public void setExpires (String expires)
    {
        this.expires = expires;
    }

    public String getStatus ()
    {
        return status;
    }

    public void setStatus (String status)
    {
        this.status = status;
    }

    public String getCache_key ()
    {
        return cache_key;
    }

    public void setCache_key (String cache_key)
    {
        this.cache_key = cache_key;
    }

    public String getEtag ()
    {
        return Etag;
    }

    public void setEtag (String Etag)
    {
        this.Etag = Etag;
    }

    public Auth getAuth ()
    {
        return auth;
    }

    public void setAuth (Auth auth)
    {
        this.auth = auth;
    }

    public String getVersion ()
    {
        return version;
    }

    public void setVersion (String version)
    {
        this.version = version;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [status_code = "+status_code+", expires = "+expires+", status = "+status+", cache_key = "+cache_key+", Etag = "+Etag+", auth = "+auth+", version = "+version+"]";
    }
}
			
			