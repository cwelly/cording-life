using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class enableextin_tuto : MonoBehaviour {
    [SerializeField] public Text imform1;
    [SerializeField] public Text imform2;
    [SerializeField] public Image im_nar;
    public GameObject fireextin;
    private float time = 10;
    private bool enablestart = false;

    // Use this for initialization
    void Start () {
        imform1.enabled = false;
        imform2.enabled = false;
    }
	
	// Update is called once per frame
	void Update () {
        if (enablestart) {
            time -= Time.deltaTime;
            im_nar.enabled = true;
            if (time >= 5)
            {
                imform1.enabled = true;

            }
            else if (time >= 0)
            {
                imform1.enabled = false;
                imform2.enabled = true;
            }
            else {
                imform2.enabled = false;
                im_nar.enabled = false;
                enablestart = false;
            }
        }
	}

    private void EnableExtin() {
        enablestart = true;
        fireextin.SetActive(true);
    }
}
