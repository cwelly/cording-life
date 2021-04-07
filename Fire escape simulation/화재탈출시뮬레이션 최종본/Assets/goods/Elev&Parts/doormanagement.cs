using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class doormanagement : MonoBehaviour {
    public GameObject left;
    public GameObject right;
    public GameObject enable_space;
    public GameObject sound1;
    public GameObject sound2;
    [SerializeField] public Text elev_inform;
    [SerializeField] public Image im;

    private bool touchable = true;
    public bool enable = false;
    private bool closing = false;
    private float ratio = 1;
    private float speed = 0.8f;
    private float wait = 2;

    void Start()
    {
        im.enabled = false;
        elev_inform.enabled = false;
    }



    // Update is called once per frame
    void Update () {

        if (enable && ratio >= -1)
        {
            sound1.SendMessage("enableSound");
            im.enabled = false;
            elev_inform.enabled = false;
            ratio -= Time.deltaTime * speed;
            left.transform.Translate(Time.deltaTime * speed, 0, 0);
            right.transform.Translate(Time.deltaTime * speed, 0, 0);
            if (ratio <= -1)
            {
                ratio = -1;

                enable = false;
            }
        }
        else if (ratio == -1&& !closing) {
            sound1.SendMessage("disableSound");
            im.enabled = false;
            elev_inform.enabled = false;
            wait -= Time.deltaTime;
            if (wait <= 0) {
                wait = 2;
                closing = true;
            }
        }
        else if (closing && ratio <= 1)
        {
            sound2.SendMessage("enableSound");
            im.enabled = false;
            elev_inform.enabled = false;
            ratio += Time.deltaTime * speed;
            left.transform.Translate(-Time.deltaTime * speed, 0, 0);
            right.transform.Translate(-Time.deltaTime * speed, 0, 0);
            if (ratio >= 1)
            {
                ratio = 1;
                closing = false;
                touchable = true;
                sound2.SendMessage("disableSound");
            }
        }
        

    }
    private void OnTriggerStay(Collider col)
    {
        if (col.tag == "Player")
        {
            Debug.Log("colli..");
            if (touchable)
            {
                elev_inform.enabled = true;
                im.enabled = true;
                if (OVRInput.Get(OVRInput.Button.PrimaryIndexTrigger) || Input.GetKey(KeyCode.Space))
                {

                    Debug.Log("go");
                    enable = true;
                    touchable = false;
                }
            }
        }
    }
    private void OnTriggerExit(Collider col)
    {
        if (col.tag == "Player") {
            im.enabled = false;
            elev_inform.enabled = false;
        }
    }
}



