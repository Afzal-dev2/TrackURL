import requests

def main(url):
    redirect = []
    try:
        resp = requests.get(url)
        if resp.history:
            for r in resp.history:
                 redirect.append(r.url)
            return "Redirected Chain:\n" + str(redirect) + "\nEnd URL: " + resp.url
            
        else:
            return '\nURL is Not Redirected or Shorten!'
        
    except BaseException as be:
        return be


