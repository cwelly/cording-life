using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class disableExtin : MonoBehaviour {
    [SerializeField] public Text inform;
    [SerializeField] public Image im;
    public GameObject[] extinguisher;
    public GameObject sound;
    

    private bool Textenable = false;
    private float waittime = 2;
	// Use this for initialization
	void Start () {
        inform.enabled = false;
        im.enabled = false;
	}

    // Update is called once per frame
    void Update()
    {
        if (Textenable)
        {
            for (int i = 0; i < extinguisher.Length; i++)
            {
                sound.SendMessage("disableSound");
                extinguisher[i].SetActive(false);

                inform.enabled = true;
                im.enabled = true;
                waittime -= Time.deltaTime;
                if (waittime < 0) {
                    im.enabled = false;
                    inform.enabled = false;
                }

            }
        }
    }

    private void OnTriggerExit(Collider col)
    {
        if (col.tag == "Player"&&waittime ==2) {
            Textenable = true;
        }
    }
}
