public class Codec {
	private List<String> shortURL = new ArrayList<String>();
	
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
    	shortURL.add(longUrl);
    	return "http://tinyurl.com/" + (shortURL.size()-1) ;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
    	return shortURL.get( Integer.parseInt( shortUrl.substring(19) ) );
    }

}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
