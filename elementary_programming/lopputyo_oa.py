#lisätään tarvittavat kirjastot.
import haravasto
import random
import time

#globaali muuttujat joihin viitataan myöhemmin
tila = {
    "kentta": [],           # piilotettu kenttä
    "pelaajan_kentta": [],  # näkyvä kenttä 
    "leveys": 0,            # kentän leveys
    "korkeus": 0,           # kentän korkeus
    "miinat": 0,            # miinojen määrä     
    "siirrot": 0,           # siirtojen määrä            
    "jaljella": 0,          # käytetään miinoittamisen kohdan määrittelyyn
    "tim": 0,               # aikamuuttuja tuloksiin
    "tarve": 0              # vertaillaan miinojen määrää ja avattuja ruutuja
}
#funktio joka lisää käyttäjän määrittämän määrän miinoja satunnaisesti kentälle
def miinoita():
    for i in range(tila["miinat"]):
        random_numero = random.randint(0, len(tila["jaljella"]) - 1)
        x, y = tila["jaljella"][random_numero]
        tila["jaljella"].pop(random_numero)
        tila["kentta"][y][x]= "x"

#funktio joka piirtää peli-ikkunan
def piirra_kentta():
    haravasto.tyhjaa_ikkuna()
    haravasto.piirra_tausta()
    haravasto.aloita_ruutujen_piirto()
    for y, rivi in enumerate(tila["pelaajan_kentta"]):
        for x, ruutu in enumerate(rivi):
            korkeus = y * 40
            leveys = x * 40
            haravasto.lisaa_piirrettava_ruutu(ruutu, leveys, korkeus)
            haravasto.piirra_ruudut()
            
#hiirenkäsittely funktio
def kasittele_hiiri(x, y, nappi, muokkausnapit):
    h = int(x / 40)
    w = int(y / 40)
    if nappi == 1:
        tila["siirrot"] += 1
        if tila["kentta"][w][h] == "x":
            tila["pelaajan_kentta"] = tila["kentta"]
            havio()
        if tila["kentta"][w][h] == "0":
            tulvataytto(w, h)
            voiton_tarkistus()
        else:
            tila["pelaajan_kentta"][w][h] = tila["kentta"][w][h]
            voiton_tarkistus()
    elif nappi == 4: 
        if tila["pelaajan_kentta"][w][h] == " ":
            tila["pelaajan_kentta"][w][h] = "f"
        elif tila["pelaajan_kentta"][w][h] == "f":
            tila["pelaajan_kentta"][w][h] = " "           

#funktio joka lisää numerot ruutuihin miinojen lähettyvissä  ( funktion nimi mahdollisesti liian samanlainen )          
def numeroi():
    for r in range(tila["korkeus"]):
        for s in range(tila["leveys"]):
            miinojen_maara = 0
            for i in range(r - 1, r + 2):
                for j in range(s - 1, s + 2):
                    if not (i < 0 or i > (tila["korkeus"] - 1) or j < 0 or j > (tila["leveys"]- 1)):
                        if tila["kentta"][i][j] == "x":
                            miinojen_maara += 1
            if tila["kentta"][r][s] != "x":  
                tila["kentta"][r][s] = str(miinojen_maara)

#pääfunktio
def main():
    haravasto.lataa_kuvat("spritet")
    haravasto.luo_ikkuna(40 * tila["leveys"], 40 * tila["korkeus"])
    haravasto.aseta_piirto_kasittelija(piirra_kentta)
    haravasto.aseta_hiiri_kasittelija(kasittele_hiiri)
    haravasto.aloita()

#rakentaa kentän pelaajan määrittelemien asetusten mukaisesti
def pelikentta():
    while True: 
        try:           
            korkeus = int(input("Kuinka korkea pelikenttä?: ")) 
            leveys = int(input("Kuinka leveä pelikenttä?: "))
            miinat = int(input("Kuinka monta miinaa?: "))
            if korkeus < 1 or leveys < 1:
                print("Anna nollaa isompi luku.")               
                continue
            elif korkeus > 24 or leveys > 40:
                print("Anna pienempi kenttä.")
                continue 
            elif miinat > (leveys * korkeus - 1):
                print("Vähemmän miinoja, kiitos.")
                continue
            tila["korkeus"] = korkeus 
            tila["leveys"] = leveys
            tila["miinat"] = miinat
            peli()
            piirra_kentta()
            break
        except ValueError:
            print("Anna kokonaisluku.")

#valikkofuntiosta seuraava funktio joka asettaa pelin tarpeelliset tiedot
def peli():    
    kentta = []
    pelaajan_kentta = []
    # luo piilokentän
    for rivi in range(tila["korkeus"]): 
        kentta.append([])
        for sarake in range(tila["leveys"]):
            kentta[-1].append(" ")
    # luo näkyvän kentän
    for rivi in range(tila["korkeus"]):
        pelaajan_kentta.append([])
        for sarake in range(tila["leveys"]):
            pelaajan_kentta[-1].append(" ")
    tila["kentta"] = kentta       
    tila["pelaajan_kentta"] = pelaajan_kentta
    jaljella = []
    for x in range(tila["leveys"]):
        for y in range(tila["korkeus"]):
            jaljella.append((x, y))
    tila["jaljella"] = jaljella
    miinoita()
    numeroi()
    main()

#valikkofunktio
def menu():
    while True:
        print("\n\n*****Tervetuloa Miinaharavaan*****\n\n")
        print(time.strftime("Tänään on %d %b\n"))
        print("Valitse 1 vaihtoehto: (A)loita peli, (E)delliset tulokset, (D)eletoi aijemmat tulokset, (L)opeta peli: ")
        #siirrot muuttuja laskee vain hiirren vasemman napin painallukset
        tila["siirrot"] = 0
        valinta = input("Tee valintasi: ").strip().lower()
        if valinta == "a":
            aloita_aika = time.time() #kun aloitat pelin, ajanlaskuri alkaa
            tila["tim"] = aloita_aika #tallentaa tilamuuttujaan "tim"
            pelikentta()
        elif valinta == "e": #edelliset tulokset
            tulos()
        elif valinta == "d": #delete earlier results
            print("Oletko varma?")
            kumpi = input("Kirjoita y jos olet varma: ").strip().lower()
            if kumpi == "y": #confirm
                tyhjennys()
                print("\n\nPoistettu")
            else:
                menu()
        elif valinta == "l": #pelin lopettaminen
            print("\nLopetetaan peli...\n")
            quit()
            break
        else:        # exception
            print("\nValitsemaasi toimintoa ei ole olemassa\n")

#tulvatäyttö funktio            
def tulvataytto(x, y):
    lista = [(x, y)]
    while lista:
        y, x = lista.pop()
        tila["pelaajan_kentta"][y][x] = tila["kentta"][y][x]
        if tila["kentta"][y][x] == "0":
            for i in range(y - 1, y + 2):
                for j in range(x - 1, x + 2):
                    if not (i < 0 or i > (tila["korkeus"] - 1) or j < 0 or j > (tila["leveys"]- 1)):
                        if tila["pelaajan_kentta"][i][j] == " ":
                            lista.append((i, j)) 
 
#funktio joka suoritetaan kun pelaaja häviää pelin 
def havio():
    print("Hävisit pelin")
    lopeta_aika = 0       
    lopeta_aika = time.time()
    endtim = tila["tim"]
    ajastin = (int(lopeta_aika) - int(endtim)) / 60
    tulos = "\n\nHäviö" 
    tulos += time.strftime("\n%a, %d %b %Y %H:%M:%S\n")
    tulos += "Pelin kesto: " + str(round(ajastin,2)) + " minuttia\n"
    tulos += "Kentän koko: " + str(tila["korkeus"]) + " x " + str(tila["leveys"])
    tulos += "\nMiinoja: " + str(tila["miinat"])
    tulos += "\nSiirrot: " + str(tila["siirrot"]) + "\n"
    tallenna_tulos(tulos)
    haravasto.lopeta()
    menu()

#funktio joka tarkistaa onko pelaaja voittanut pelin vai ei
def voiton_tarkistus():
    tila["tarve"] = tila["korkeus"] * tila["leveys"] - tila["miinat"]
    for x in range(tila["korkeus"]):
        for y in range(tila["leveys"]):
            if tila["pelaajan_kentta"][x][y] != " ":
                if tila["pelaajan_kentta"][x][y] != "f":
                    tila["tarve"] -= 1
    if tila["tarve"] == 0:
        print("\nVoitit pelin.")
        lopeta_aika = 0
        lopeta_aika = time.time()
        endtim = tila["tim"]
        ajastin = (int(lopeta_aika) - int(endtim)) / 60
        tulos = "\n\nVoitto" 
        tulos += time.strftime("\n%a, %d %b %Y %H:%M:%S\n")
        tulos += "Pelin kesto: " + str(round(ajastin,2)) + " minuttia\n"
        tulos += "Kentän koko: " + str(tila["korkeus"]) + " x " + str(tila["leveys"])
        tulos += "\nMiinoja: " + str(tila["miinat"])
        tulos += "\nSiirrot: " + str(tila["siirrot"]) + "\n"
        tallenna_tulos(tulos)
        haravasto.lopeta()
        menu()
        
#funktio joka tallentaa tulokset erilliseen tiedostoon
def tallenna_tulos(tulos):
    with open("tulokset.txt", "a") as save:
        save.write(tulos)

#funktio joka avaa tulokset pelaajan nähtäväksi
def tulos():
    try:
        with open("tulokset.txt") as t:
            lue = t.read()
            print(lue)
    except FileNotFoundError:
        print("Ei fileä. Pelaa peli ensin.")

#funktio joka tyhjentää tallennetut tulokset
def tyhjennys():
    try:
        with open("tulokset.txt","r+") as de:
            de.truncate(0)
            de.close()
    except FileNotFoundError:
        print("Et voi poistaa mitä ei ole!")
        
#avaa pelin valikon
if __name__ == "__main__":  
    menu()